package Queue.Deque;

import java.util.Deque;
import java.util.Stack;

public class StackUsingDq {
    static class Stack {

        static Deque<Integer> d = new LinkedList<>();

        // add
        public static void push(int data) {
            d.addLast(data);
        }

        // remove
        public static int pop() {
            return d.removeLast();
        }

        // peek
        public static int peek() {
            return d.getLast();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek" + s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
