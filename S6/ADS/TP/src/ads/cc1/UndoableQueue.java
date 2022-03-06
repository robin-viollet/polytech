package ads.cc1;

import ads.lab2.EmptyQueueException;
import ads.lab2.EmptyStackException;

import java.util.Stack;

public class UndoableQueue<AnyType> {

    private enum Action { ENQUEUE, DEQUEUE };

    private Stack<AnyType> in;
    private Stack<AnyType> out;

    private Stack<AnyType> dequeued;
    private Stack<Action> action;

    public UndoableQueue() {
        in  = new Stack<AnyType>();
        out = new Stack<AnyType>();
        dequeued = new Stack<AnyType>();
        action   = new Stack<Action>();
    }

    public int size() {
        return in.size() + out.size();
    }

    public AnyType peek() throws EmptyQueueException{
        try {
            if ( out.isEmpty() )
                transfer(in,out);
            return out.peek();
        }
        catch (EmptyStackException e) {
            throw new EmptyQueueException();
        }
    }

    public void clear() {
        in.clear();
        out.clear();
        action.clear();
        dequeued.clear();
    }

    private void transfer(Stack<AnyType> from, Stack<AnyType> to) throws EmptyStackException {
        while (! from.isEmpty() )
            to.push(from.pop());
    }

    public void enqueue(AnyType x) {
        action.push(Action.ENQUEUE);
        in.push(x);
    }

    public AnyType dequeue() throws EmptyQueueException {
        try {
            transfer(in, out);
            action.push(Action.DEQUEUE);
            return dequeued.push(out.pop());
        }catch (EmptyStackException e){
            throw new EmptyQueueException();
        }
    }

    public void undo() {
        switch (action.pop()){
            case ENQUEUE -> in.pop();
            case DEQUEUE -> in.push(dequeued.pop());
        }
    }

    @Override
    public String toString(){
        return  in.toString() + out.toString();
    }
}