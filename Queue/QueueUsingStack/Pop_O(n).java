package Queue.QueueUsingStack;

public class Pop_O(n) {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // Check if the queue is empty
        public static boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        // Add an element to the queue (O(1))
        public static void add(int data) {
            s1.push(data); // Always push to s1
        }

        // Remove the front element from the queue (O(n) during transfer)
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            // Transfer elements from s1 to s2 only if s2 is empty
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            // Pop the top element from s2
            return s2.pop();
        }

        // Peek at the front element without removing it (O(n) during transfer)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            // Transfer elements from s1 to s2 only if s2 is empty
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            // Peek the top element from s2
            return s2.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.pop());
        }
    }
}
