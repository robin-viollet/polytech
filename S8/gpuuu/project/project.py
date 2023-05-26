#!/usr/bin/env python

# Use cuda from numba to access the GPU's processing power
# Use numpy to handle arrays conveniently and FASTLY
# Use math to handle log2, ceil and pow
# Use sys to access the args and exit()
from numba import cuda
import numpy as np
import math
import sys

# The number of threads in each block used to process the arrays
# The value 1024 has been chosen because it is the highest allowed
# and permits to eat big arrays fast
threadsPerBlock = 1024


# GPU compute, highly parallel (yay!)
def scanGPU(array):
    # We store the array size, so we can copy back only the wanted values
    array_size = array.shape[0]

    # We compute the nearest power of two that is greater than  array_size
    n = int(math.pow(2, math.ceil(math.log2(array_size))))

    # We pad the array with values so the array's size is a power of two
    array = np.pad(array, (0, n - array_size))

    # Copy the array to the GPU's global memory
    d_array = cuda.to_device(array)

    # Compute the number of blocks needed to process the whole array, with the previously defined block size
    blocksPerGrid = math.ceil(n / threadsPerBlock)

    # Call the kernel with the computed size and pass the array to compute
    scanKernel[blocksPerGrid, threadsPerBlock](d_array)

    # Wait for the threads to finish
    cuda.synchronize()

    # Copy back the array and return only the relevant slice
    return d_array.copy_to_host()[:array_size]


# Cuda Kernel computing a scan prefix
@cuda.jit
def scanKernel(a):
    # Get the size of the array
    n = a.shape[0]

    # Let cuda compute the global id
    global_id = cuda.grid(1)

    # Compute the exponent of the power of two that is the nearest to n
    m = math.ceil(math.log2(n))

    # Generate an array with a size equals to the number of threads that is stored in the shared memory,
    # so we can handle big arrays
    shared_array = cuda.shared.array(threadsPerBlock, dtype=np.int32)

    # Each thread copies a number from the global array to the shared array
    shared_array[cuda.threadIdx.x] = a[cuda.threadIdx.x]

    # Wait for all the threads to finish the copy
    cuda.syncthreads()

    # up-sweep
    # Iterate over all values from 0 to m - 1 (included)
    for d in range(0, m):
        # Compute one time 2 to the power of d, so we can reuse it
        dpow = 2 ** d

        # Compute an index k from the local id times 2^(d+1) (2^(d+1) = 2^d*2)
        k = cuda.threadIdx.x * dpow * 2

        # If k is less than n, we are not outside the array
        if k < n:
            # Add one cell value to another
            shared_array[k + dpow * 2 - 1] += shared_array[k + dpow - 1]

        # Wait for all the threads to finish the up-sweep
        cuda.syncthreads()

    # down-sweep
    # Set the last cell of the array to 0
    shared_array[n - 1] = 0

    # Iterate over the values from 0 to m - 1 (included), in reverse order
    for d in range(m - 1, -1, -1):
        # Compute one time 2 to the power of d, so we can reuse it
        dpow = 2 ** d

        # Compute an index k from the local id times 2^(d+1) (2^(d+1) = 2^d*2)
        k = cuda.threadIdx.x * dpow * 2

        # If k is less than n, we are not outside the array
        if k < n:
            # Compute the sum t to put in the array
            t = shared_array[k + dpow - 1]

            # Swap the values of two cells
            shared_array[k + dpow - 1] = shared_array[k + dpow * 2 - 1]

            # Add t to a cell
            shared_array[k + dpow * 2 - 1] += t

        # Wait for all the threads to finish the down-sweep
        cuda.syncthreads()

    # Copy all the values from the shared array to the global so the cpu part can retrieve the result
    a[global_id] = shared_array[global_id]


# USED ONLY FOR DEBUGGING PURPOSES - CPU compute, sequential
def scanCPU(a):
    # print(a)
    n = a.shape[0]
    m = math.ceil(math.log2(n))
    # print("log2", n, "=", m)
    # up-sweep
    for d in range(0, m):
        # print("d", d)
        dpow = 2 ** d
        for k in range(0, n, dpow * 2):
            # print("k", k, "n", n, "d", d, "m", m)
            # print("a[", k + dpow * 2 - 1, "] += a[", k + dpow - 1, "] (", a[k + dpow - 1], ")")
            a[k + dpow * 2 - 1] += a[k + dpow - 1]

    # down-sweep
    a[n - 1] = 0
    for d in range(m - 1, -1, -1):
        dpow = 2 ** d
        for k in range(0, n, dpow * 2):
            t = a[k + dpow - 1]
            a[k + dpow - 1] = a[k + dpow * 2 - 1]
            a[k + dpow * 2 - 1] += t

    return a


# USED ONLY FOR DEBUGGING PURPOSES - "Handmade" CPU compute (always right, used as a reference). Completely sequential
def scanCPUprint(array):
    sum = 0
    darray = np.zeros(array.shape, int)
    for i in range(0, array.shape[0]):
        if (i == 0):
            darray[i] = 0
        else:
            sum = sum + array[i - 1]
            darray[i] = sum
    return darray

# Print the given array with the format (array[0],array[1],...,array[n-1])
def printArray(array):
    # Print all the elements of the array each seperated by a comma (","), without square brackets ("[", "]"),
    # without spaces (" ") and without line returns ("\n")
    print(np.array2string(array,
        separator=",",
        threshold=array.shape[0])
            .strip('[]')
            .replace('\n', '')
            .replace(' ', ''))

# The main function parses the args and calls the function to compute the prefix sum
def main():
    # Get access to the global variable threadsPerBlock
    global threadsPerBlock

    # Has the --tb parameter been passed
    tb = False
    # Has the --independent parameter been passed
    ind = False
    # Has the --inclusive parameter been passed
    inc = False

    # Start optional args parsing at index 2 because 0 is the executable name and 1 is the input file
    index = 2

    # Check that required arguments are passed
    if len(sys.argv) < index:
        # Print the usage explaining how to use the software
        print("Usage: ", sys.argv[0], "<inputFile> [--tb int] [--independent] [--inclusive]")

        # Exit with an error code
        sys.exit(1)

    # If we have more than 2 args,
    if len(sys.argv) >= index + 1:
        # Check that the next arg is --tb
        if sys.argv[index] == "--tb":
            # --tb has been passed
            tb = True

            # Set the threads per block value to the parsed value
            threadsPerBlock = int(sys.argv[index + 1])

        # Pass the next arg as it is the numeric value we parse
        index += 2

    # If we have more than 3 args,
    if len(sys.argv) >= index + 1:
        # Check that the next arg is --independent
        if sys.argv[index] == "--independent":
            # --independent has been used
            ind = True

        # Go to the next arg
        index += 1

    # If we have more than 4 args,
    if len(sys.argv) >= 4:
        # Check that the next arg is --inclusive
        if sys.argv[index] == "--inclusive":
            # --inclusive has been used
            inc = True

        # Go to the next arg
        index += 1

    # Open the data file whose name is passed as the first argument
    file = open(sys.argv[1], 'r')

    # Split file content at each comma (","), then parse each value as int and put in array
    array = np.array(file.read().split(','), int)

    # Call the function that starts the GPU kernel, passing it the array and print the result with the right format
    printArray(scanGPU(array))


if __name__ == "__main__":
    main()
