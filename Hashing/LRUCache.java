package Hashing;
/*
 
 * Static methods belong to the class itself, not to an individual object (instance).
 * Non-static methods operate on instance variables and require an object to be invoked.

 */

/*
 * Why These Methods Should Be Non-Static?
   ✅ Each LRUCache instance has its own state
   When you create multiple instances of LRUCache, each instance has:

  * Its own capacity
  * Its own HashMap (map)
  * Its own doubly linked list (head, tail)
   ❌ If the methods were static:
  * They wouldn’t have access to instance-specific data (this.map, this.head, this.tail).
  * They would have to work with static (shared) data, which would break the logic of multiple cache instances.
 */

import java.util.*;

public class LRUCache { // ✅ Standalone class, not nested

    static class Node {
        int key, value;
        Node next, prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addFront(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        delete(node);
        addFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            delete(node);
            addFront(node);
            return;
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            map.remove(lru.key);
            delete(lru);
        }

        Node newNode = new Node(key, value);
        addFront(newNode);
        map.put(key, newNode);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // ✅ Now you can instantiate LRUCache
        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1)); // Output: 10
        cache.put(3, 30); // Evicts key 2
        System.out.println(cache.get(2)); // Output: -1 (not found)

        LRUCache cache2 = new LRUCache(3);
        cache2.put(1, 30);
        cache2.put(2, 10);
        System.out.println(cache2.get(1));
        cache2.put(3, 90);
        System.out.println(cache2.get(6));
    }
}




/*

 // what if i make make static methods and instance variables static

 * If you make both the instance variables and the methods static in the LRUCache class, the program will run, but it will behave incorrectly and not function as an LRU cache anymore.
 * 
 * When you make both the instance variables and the methods static, everything will become shared across all instances of the class. This is not what you want for an LRU Cache, where each cache should have its own separate data structure.
 * 
 * Example : 
 * LRUCache cache1 = new LRUCache(2);
   cache1.put(1, 10);
   cache1.put(2, 20);

   LRUCache cache2 = new LRUCache(3);  // capacity is now 3 for both cache1 and cache2
   cache2.put(3, 30);  // This modifies cache1's shared state too!

   System.out.println(cache1.get(1)); // ✅ Output: 10
   System.out.println(cache2.get(1)); // ✅ Output: 10 (since it's shared)
 */


/*
 * Yes, if you make everything static in your LRUCache implementation, it will work more like a single global cache instead of multiple independent caches. The behavior will be very different from the typical behavior expected from a cache problem, where each cache instance should have its own state.
 */


 /*

  The this keyword is used to refer to instance variables (non-static fields) and instance methods of the current object. You do not need static to use this. In fact, this can only be used in the context of an instance (non-static) method or constructor to refer to the current instance of that class.

  * why (this) keyword not work for static class 

  Why Doesn't this Work in Static Methods or Static Blocks?
  In Java, this refers to the current instance of the object. It is used to refer to instance variables, methods, or the current object itself. However, when you make a method or variable static, it no longer belongs to any particular instance of the class, and instead belongs to the class itself.

  Key Points About Static and this:
  this is used for instance members (variables and methods), so it requires an object to refer to.

  In non-static methods, you can use this to refer to the current object.
  Static members belong to the class and do not require an object. Static methods and variables are called using the class name, and they do not have access to the instance members or the current object (this) because there is no specific object.
  
  Static methods cannot use this because there is no instance of the class associated with a static method — it is associated with the class itself.

  */



/* Yes — deleting directly from an actual node is 100% possible in a doubly linked list. 
 * Why?
Each node in a doubly linked list has:

A reference to its next node: node.next

A reference to its previous node: node.prev

So if you already have a reference to a node, you can delete it in constant O(1) time using just its neighbors
*/