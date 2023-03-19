package ads.lab5;

import java.util.Comparator;

/**
 * A class for dynamic median finding.
 */
public class DynamicMedian<AnyType extends Comparable<? super AnyType>> {

	private BinaryHeap<AnyType> less;    // to store values less than or equal to the median
	private BinaryHeap<AnyType> greater; // to store values greater than or equal to the median

	/**
	 * Build a DynamicMedian object of maximum capacity n
	 */
	public DynamicMedian(int n) {
		Comparator<AnyType> c = new Comparator<AnyType>() {
			public int compare(AnyType e1, AnyType e2) {
				return e2.compareTo(e1);
			}
		};
		less = new BinaryHeap<AnyType>(n);
		greater = new BinaryHeap<AnyType>(n,c);
	}

	/**
	 * Return the size (the number of elements
	 * currently in the DynamicMedian object)
	 * Complexity: THETA(1)
	 */
	public int size() {
		return less.size() + greater.size();
	}

	/**
	 * Add a new element e.
	 * Complexity: O(log(size))
	 */
	public void add(AnyType e) throws EmptyHeapException, FullHeapException {
		if ( less.isEmpty() || e.compareTo(less.extreme()) <= 0 ) {
			less.add(e);
			if ( less.size() > greater.size() + 1 )
				greater.add(less.deleteExtreme());
		}
		else {
			greater.add(e);
			if ( less.size() < greater.size() )
				less.add(greater.deleteExtreme());
		}
	}

	/**
	 * Return the current median.
	 * Complexity: THETA(1)
	 */
	public AnyType findMedian() throws EmptyHeapException {
		return less.extreme();
	}

	/**
	 * Return and delete the current median
	 * Complexity: O(log(size))
	 */
	public AnyType deleteMedian() throws EmptyHeapException, FullHeapException {
		AnyType median = less.deleteExtreme();
		if ( less.size() < greater.size() )
			less.add(greater.deleteExtreme());
		return median;
	}
}
