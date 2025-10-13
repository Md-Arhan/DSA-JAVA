package Stacks.StackImplementation;

public class JCF {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}

/*
 * 1. Originally, Java made Stack as a ready-to-use class
 * When Java first released collections, it included some prebuilt classes like
 * Stack, Vector, and Hashtable.
 * 
 * At that time, the idea was:
 * 
 * "Here’s a stack. Just use it."
 * 
 * There wasn’t much emphasis on writing your own or swapping implementations.
 * So they just gave a concrete class with actual logic, not an interface with
 * abstract behavior.
 * 
 * 2. Stack has very specific behavior
 * The stack data structure follows LIFO (Last In, First Out). The essential
 * operations are:
 * 
 * push()
 * 
 * pop()
 * 
 * peek()
 * 
 * Unlike List, Queue, or Map, which have lots of variations (ArrayList,
 * LinkedList, PriorityQueue, HashMap, etc.), a Stack has fewer meaningful
 * implementation variations — so Java didn’t see a strong need to make it an
 * interface back then.
 * 
 * 3. Modern Java prefers Deque over Stack
 * Instead of Stack, modern Java developers use ArrayDeque with the Deque
 * interface, because it's faster and more flexible.
 */