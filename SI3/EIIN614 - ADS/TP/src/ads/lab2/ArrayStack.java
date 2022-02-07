package ads.lab2;

/**
 * An array-based stack class
 */
public class ArrayStack<AnyType> {
	
	private static final int DEFAULT_CAPACITY = 32;
	
	private AnyType[] array;
	private int size;
	
	/**
	 * Build an empty stack
	 * Complexity: THETA(1)
	 */
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Build an empty stack of
	 * a given capacity
	 * Complexity: THETA(1)
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		array = (AnyType[]) new Object[capacity];
		size = 0;
	}
	
	/**
	 * Check if the stack is empty
	 * Complexity: THETA(1)
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Return the number of items
	 * currently in the stack
	 * Complexity: THETA(1)
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Return the next value to be popped from the stack
	 * Throw EmptyStackException if the stack is empty
	 * Complexity: THETA(1)
	 */	
	public AnyType peek() throws EmptyStackException {
		if (size == 0){
			throw new EmptyStackException();
		}

		return array[size - 1];
	}
	
	/**
	 * Push the value x onto the stack.
	 * If needed, the underlying array 
	 * will be enlarged by twice its size
	 * Complexity: amortized O(1)
	 */
	@SuppressWarnings("unchecked")
	public void push(AnyType x) {
		if (size == array.length){
			AnyType[] newArray = (AnyType[]) new Object[array.length * 2];
			for (int i = 0; i < array.length; ++i){
				newArray[i] = array[i];
			}
			array = newArray;
		}

		array[size++] = x;
	}
	
	/**
	 * Pop the stack and return the value popped
	 * Throw EmptyStackException if the stack is empty
	 * Complexity: THETA(1)
	 */
	public AnyType pop() throws EmptyStackException {
		return array[--size];
	}
	
	/**
	 * Remove all elements in the stack
	 * Complexity: THETA(1) where n is the
	 * size of the stack
	 */
	@SuppressWarnings("unchecked")
	public void clear() {
		array = (AnyType[]) new Object[array.length];
		size = 0;
	}
	
	/**
	 * Return a string representation of the stack
	 * in the form of "[ A B C ->" where A is the
	 * bottom and C the top of the stack
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ ");
		for (AnyType elm : array){
			builder.append(elm).append(' ');
		}
		builder.append("->");
		return builder.toString();
	}
	
    /**
     * A short main for quick testing
     */
	public static void main(String[] args) throws EmptyStackException {
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		for ( int i = 1; i <= 100; i++ )
			stack.push(i);
		int i = 0;
		while ( ! stack.isEmpty() ) {
			if ( i++ % 25 == 0 )
				System.out.println();
			System.out.print(stack.pop() + " ");
		}
			
		System.out.println();
	}
	// expected output:
	//
	// 100 99 98 97 96 95 94 93 92 91 90 89 88 87 86 85 84 83 82 81 80 79 78 77 76 
	// 75 74 73 72 71 70 69 68 67 66 65 64 63 62 61 60 59 58 57 56 55 54 53 52 51 
	// 50 49 48 47 46 45 44 43 42 41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 
	// 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
}
