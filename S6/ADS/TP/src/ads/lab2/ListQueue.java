package ads.lab2;

/**
 * A class for list-based queue
 */
public class ListQueue<AnyType> implements QueueInterface<AnyType> {
	

	/**
	 * Build an empty queue
	 * Complexity: THETA(1)
	 */
	public ListQueue() {

	}
		
	/**
	 * Return the number of elements
	 * currently in the queue
	 * Complexity: THETA(1)
	 */
	public int size() {
		return 0;
	}
	
	/**
	 * Return the next value to be dequeued
	 * If the queue is empty throws EmptyQueueException
	 * Complexity: THETA(1)
	 */
	public AnyType peek() throws EmptyQueueException {
		return null;
	}
	
	/**
	 * Enqueue x in the queue
	 * Complexity: THETA(1)
	 */
	public void enqueue(AnyType x) {

	}
	
	/**
	 * Dequeue and return the next element to
	 * be dequeued
	 * If the queue is empty throws EmptyQueueException
	 * Complexity: THETA(1)
	 */
	public AnyType dequeue() throws EmptyQueueException {
		return null;
	}
	
	/**
	 * Return a string representation of the queue
	 * in the form of "<- A B C <-" where A is the
	 * front and C the tail of the queue
	 * Complexity: THETA(n) where n is the number
	 * of items currently in the queue
	 */	
	public String toString() {
		return "";
	}
	
	//////////////////////////////////////////////
	
	/**
	 * A private class for list node
	 */
	private class ListNode {
		AnyType data;
		ListNode next;
		
		ListNode(AnyType data) {
			this.data = data;
			this.next = null;
		}
	}
}
