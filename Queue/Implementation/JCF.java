package Queue.Implementation;

public class JCF {
    public static void main(String[] args) {
        // Queue cant be an object because it is an interface, it must be created from
        // ArrayDequeue or LinkedList
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}

/*
 * 1. Multiple Implementations Are Possible
 * If Queue were a class, you couldn’t have this flexibility — interfaces allow
 * multiple classes to implement their own version of a queue.
 * 
 * 2. Abstraction
 * Interfaces allow Java to define what a queue should do (methods like add(),
 * remove(), peek()) without saying how it's done.
 * 
 * This follows the principle of
 * "program to an interface, not an implementation" — so code stays flexible and
 * reusable.
 * 
 * 
 * 3. Standardization
 * By making Queue an interface, Java standardizes queue behavior across
 * different libraries and APIs. So whenever you're working with something that
 * is a queue, you know it supports a known set of methods like offer(), poll(),
 * and peek().
 * 
 * In Summary:
 * Queue is an interface because it describes behavior, not structure.
 * 
 * Java lets you choose your implementation based on your use case.
 * 
 * This makes your code more flexible, reusable, and clean.
 * 
 */