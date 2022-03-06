package ads.cc1;

import ads.lab2.EmptyQueueException;

public class Main {

    public static boolean sum(int[] A, int s) {
        return sum(A, s, A.length);
    }

    private static boolean sum(int[] A, int s, int k) {
        if (s < 0) return false;
        if (s == 0) return true;
        if (k == 0) return false;
        return sum(A, s, k - 1) || sum(A, s - A[k - 1], k);

    }

    public static void main(String[] args) throws EmptyQueueException{
        //System.out.println(sum(new int[]{5,11,3},13));
        //System.out.println(sum(new int[]{6,3},11));

        UndoableQueue<Integer> q = new UndoableQueue<>();

        q.enqueue(1); q.enqueue(2); q.enqueue(3); q.undo();
        System.out.println("la file q contient <- 1 2 <-");
        System.out.println(q);

        q = new UndoableQueue<>();

        q.enqueue(1); q.enqueue(2); q.enqueue(3); q.dequeue(); q.undo();
        System.out.println("la file q contient <- 1 2 3 <-");
        System.out.println(q);

        q = new UndoableQueue<>();

        q.enqueue(1); q.enqueue(2); q.enqueue(3); q.dequeue(); q.enqueue(4); q.undo(); q.undo();
        System.out.println("la file q contient <- 1 2 3 <-");
        System.out.println(q);

        q = new UndoableQueue<>();

        q.enqueue(1); q.enqueue(2); q.dequeue(); q.enqueue(3); q.undo(); q.undo(); q.undo();
        System.out.println("la file q contient <- 1 <-");
        System.out.println(q);
    }
}
