package ads.lab5;

import ads.util.TestClass;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A class for interactive testing of binary heap
 */
public class TestBinaryHeap extends TestClass<TestBinaryHeap> {
	
	private BinaryHeap<Integer> heap;
	private Scanner input;
	
	public TestBinaryHeap() {
		heap = new BinaryHeap<Integer>(17);
		try {
			heap.add(4);
			heap.add(16);
			heap.add(5);
			heap.add(17);
			heap.add(23);
			heap.add(7);
			heap.add(14);
			heap.add(25);
			heap.add(22);
			heap.add(24);
			heap.add(31);
			heap.add(9);
			heap.add(12);
			heap.add(15);
			heap.add(19);
			heap.add(28);
			heap.add(26);
		} catch (FullHeapException e){
			throw new RuntimeException(e);
		}

		System.out.println(heap);

		input = new Scanner(System.in);
	}
	
	public void size() {
		System.out.println(heap.size());
	}
	
	public void isEmpty() {
		if ( heap.isEmpty() )
			System.out.println("heap is empty");
		else
			System.out.println("heap is not empty");
	}
	
	public void extreme() throws EmptyHeapException {
		System.out.println(heap.extreme());
	}
	
	public void deleteExtreme() throws EmptyHeapException {
		Integer x = heap.deleteExtreme();
		System.out.println(x);
	}
	
	public void add() throws FullHeapException {
		System.out.print("Enter an integer: ");
		int x = input.nextInt();
		heap.add(x);
	}

    public static void main(String[] args) {
    	/*TestBinaryHeap test = new TestBinaryHeap();;
        test.tester();*/
		int[] array1 = {1, 2, 3, 4, 5, 6};
		System.out.println(Arrays.toString(pivots(array1)));

		int[] array2 = {1, 2, 4, 3, 5, 7};
		System.out.println(Arrays.toString(pivots(array2)));

		int[] array3 = {2, 1, 4, 3, 5, 6};
		System.out.println(Arrays.toString(pivots(array3)));

		int[] array4 = {6, 5, 4, 3, 2, 1};
		System.out.println(Arrays.toString(pivots(array4)));
    }

	public static boolean[] pivots(int[] array) {
		boolean[] tb = new boolean[array.length];

		for (int i = 0; i < tb.length; ++i){
			tb[i] = true;
			for (int j = 0; j < i; ++j){
				if (array[j]<array[i]){
					tb[i] = true;
				} else {
					tb[i] = false;
					break;
				}
			}

			if (!tb[i]){
				continue;
			}

			for (int k = i + 1; k < tb.length; ++k){
				if (array[i]<array[k]){
					tb[i] = true;
				} else {
					tb[i] = false;
					break;
				}
			}
		}

		return tb;
	}
}
