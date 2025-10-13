package Queue.Deque;

import java.util.Deque;
import java.util.Queue;

public class QueueUsingDq {
    static class Queue {
        static Deque<Integer> d = new LinkedList<>();

        // add
        public static void add(int data) {
            d.addLast(data);
        }

        // remove
        public static int remove() {
            return d.removeFirst();
        }

        // peek
        public static int peek() {
            return d.getFirst();
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue();
        Queue q1 = new Queue();
        q.add(1);
        q.add(2);
        q1.add(3);
        q.add(5);
        ;
        System.out.println(q1.remove());
        System.out.println(q1.remove());
        System.out.println(q1.remove());
        System.out.println(q.remove());
    }
}
