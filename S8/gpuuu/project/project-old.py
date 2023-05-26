#!/usr/bin/env python
from numba import cuda, types
import numpy as np
import math
import sys

threadsPerBlock = 1024


# GPU compute, highly parallel (yay!)
def scanGPU(array):
    # We store the array size so we can copy back only the wanted values
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


# Cuda Kernel
@cuda.jit
def scanKernel(a):
    # Get the size of the array
    n = a.shape[0]

    # Let cuda compute the global id
    global_id = cuda.grid(1)

    # Compute the nearest
    m = math.ceil(math.log2(n))

    # up-sweep
    for d in range(0, m):
        dpow = 2 ** d
        k = global_id * dpow * 2
        if k < n:
            a[k + dpow * 2 - 1] += a[k + dpow - 1]

        cuda.syncthreads()

    # down-sweep
    a[n - 1] = 0
    for d in range(m - 1, -1, -1):
        dpow = 2 ** d
        k = global_id * dpow * 2
        if k < n:
            t = a[k + dpow - 1]
            a[k + dpow - 1] = a[k + dpow * 2 - 1]
            a[k + dpow * 2 - 1] += t


# CPU compute, sequential
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


# "Handmade" CPU compute (always right, used as a reference). Completely sequential
def scanCPUprint(array):
    sum = 0
    darray = np.zeros(array.shape, int)
    for i in range(0, array.shape[0]):
        if (i == 0):
            darray[i] = 0
            # print(0, end=' ')
        else:
            sum = sum + array[i - 1]
            darray[i] = sum
            # print(sum, end=' ')
    return darray


def printArray(array):
    print(np.array2string(array, separator=",",threshold=array.shape[0]).strip('[]').replace('\n', '').replace(' ',''))


def main():
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
        print("Usage: ", sys.argv[0], "<inputFile> [--tb int] [--independent] [--inclusive]")
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

    print("cpuprint ")
    cpuarray = np.copy(array)
    printArray(scanCPUprint(cpuarray))

    # print("cpu ")
    # cpuarray = np.copy(array)
    # printArray(scanCPU(cpuarray))

    print("gpu ")
    gpuarray = np.copy(array)
    printArray(scanGPU(gpuarray))


if __name__ == "__main__":
    main()
