package ads.cc1;

import ads.lab2.EmptyStackException;
import ads.lab2.ListQueue;

/**
 * A class for queue-based stack
 */
public class QueueStack<AnyType> {

    private ListQueue<AnyType> q1;
    private AnyType top;

    /**
     * Build an empty queue
     * Complexity: THETA(1)
     */
    public QueueStack() {
        q1 = new ListQueue<AnyType>();
        top = null;
    }

    /**
     * Check if the stack is empty
     * Complexity: THETA(1)
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Return the next value to be popped from the stack
     * Throw EmptyStackException if the stack is empty
     * Complexity: THETA(1)
     */
    public AnyType peek() throws EmptyStackException{
        return null;
    }

    /**
     * Push the value x onto the stack.
     * Complexity: THETA(1)
     */
    public void push(AnyType x) {
    }

}