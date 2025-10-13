package Queue;

//Linked Interface Implementation

// public class Additional {
//     public interface Queue<T> {
//         void enqueue(T item); // Add an item to the queue
//         T dequeue();          // Remove and return the front item of the queue
//         T peek();             // View the front item without removing it
//         boolean isEmpty();    // Check if the queue is empty
//         int size();           // Get the number of elements in the queue
//     }

//     class Node<T> {
//         T data;
//         Node<T> next;
    
//         Node(T data) {
//             this.data = data;
//             this.next = null;
//         }
//     }

//     public class LinkedListQueue<T> implements Queue<T> {
//         private Node<T> front; // Front of the queue
//         private Node<T> rear;  // Rear of the queue
//         private int size;      // Size of the queue
    
//         public LinkedListQueue() {
//             this.front = null;
//             this.rear = null;
//             this.size = 0;
//         }
    
//         @Override
//         public void enqueue(T item) {
//             Node<T> newNode = new Node<>(item);
//             if (isEmpty()) {
//                 front = rear = newNode;
//             } else {
//                 rear.next = newNode;
//                 rear = newNode;
//             }
//             size++;
//         }
    
//         @Override
//         public T dequeue() {
//             if (isEmpty()) {
//                 throw new IllegalStateException("Queue is empty");
//             }
//             T data = front.data;
//             front = front.next;
//             if (front == null) {
//                 rear = null; // If queue becomes empty
//             }
//             size--;
//             return data;
//         }
    
//         @Override
//         public T peek() {
//             if (isEmpty()) {
//                 throw new IllegalStateException("Queue is empty");
//             }
//             return front.data;
//         }
    
//         @Override
//         public boolean isEmpty() {
//             return front == null;
//         }
    
//         @Override
//         public int size() {
//             return size;
//         }
    
//         public static void main(String[] args) {
//             Queue<Integer> queue = new LinkedListQueue<>();
//             queue.enqueue(10);
//             queue.enqueue(20);
//             queue.enqueue(30);
    
//             System.out.println("Front element: " + queue.peek());
//             System.out.println("Dequeue: " + queue.dequeue());
//             System.out.println("Front element after dequeue: " + queue.peek());
//             System.out.println("Queue size: " + queue.size());
//         }
//     }
// }



//ArrayDeque Implementation from Scratch


// public class Additional {

//     public interface Deque<T> {
//         void addFirst(T item);  // Add an item to the front
//         void addLast(T item);   // Add an item to the rear
//         T removeFirst();        // Remove and return the front item
//         T removeLast();         // Remove and return the rear item
//         T peekFirst();          // View the front item without removing it
//         T peekLast();           // View the rear item without removing it
//         boolean isEmpty();      // Check if the deque is empty
//         int size();             // Get the size of the deque
//     }

//     public class ArrayDeque<T> implements Deque<T> {
//         private T[] data;        // Array to store elements
//         private int front;       // Index of the front element
//         private int rear;        // Index of the rear element
//         private int size;        // Number of elements in the deque
//         private int capacity;    // Capacity of the deque
    
//         @SuppressWarnings("unchecked")
//         public ArrayDeque(int initialCapacity) {
//             this.capacity = initialCapacity;
//             this.data = (T[]) new Object[capacity];
//             this.front = -1;
//             this.rear = -1;
//             this.size = 0;
//         }
    
//         // Default constructor with a capacity of 10
//         public ArrayDeque() {
//             this(10);
//         }
    
//         @Override
//         public void addFirst(T item) {
//             if (size == capacity) {
//                 resize();
//             }
//             if (size == 0) {
//                 front = rear = 0;
//             } else {
//                 front = (front - 1 + capacity) % capacity;
//             }
//             data[front] = item;
//             size++;
//         }
    
//         @Override
//         public void addLast(T item) {
//             if (size == capacity) {
//                 resize();
//             }
//             if (size == 0) {
//                 front = rear = 0;
//             } else {
//                 rear = (rear + 1) % capacity;
//             }
//             data[rear] = item;
//             size++;
//         }
    
//         @Override
//         public T removeFirst() {
//             if (isEmpty()) {
//                 throw new IllegalStateException("Deque is empty");
//             }
//             T item = data[front];
//             data[front] = null;
//             front = (front + 1) % capacity;
//             size--;
//             if (size == 0) {
//                 front = rear = -1;
//             }
//             return item;
//         }
    
//         @Override
//         public T removeLast() {
//             if (isEmpty()) {
//                 throw new IllegalStateException("Deque is empty");
//             }
//             T item = data[rear];
//             data[rear] = null;
//             rear = (rear - 1 + capacity) % capacity;
//             size--;
//             if (size == 0) {
//                 front = rear = -1;
//             }
//             return item;
//         }
    
//         @Override
//         public T peekFirst() {
//             if (isEmpty()) {
//                 throw new IllegalStateException("Deque is empty");
//             }
//             return data[front];
//         }
    
//         @Override
//         public T peekLast() {
//             if (isEmpty()) {
//                 throw new IllegalStateException("Deque is empty");
//             }
//             return data[rear];
//         }
    
//         @Override
//         public boolean isEmpty() {
//             return size == 0;
//         }
    
//         @Override
//         public int size() {
//             return size;
//         }
    
//         @SuppressWarnings("unchecked")
//         private void resize() {
//             int newCapacity = capacity * 2;
//             T[] newData = (T[]) new Object[newCapacity];
//             for (int i = 0; i < size; i++) {
//                 newData[i] = data[(front + i) % capacity];
//             }
//             data = newData;
//             front = 0;
//             rear = size - 1;
//             capacity = newCapacity;
//         }
    
//         public static void main(String[] args) {
//             Deque<Integer> deque = new ArrayDeque<>(5);
    
//             // Adding elements
//             deque.addLast(10);
//             deque.addLast(20);
//             deque.addFirst(5);
//             deque.addLast(30);
    
//             System.out.println("Front element: " + deque.peekFirst()); // 5
//             System.out.println("Rear element: " + deque.peekLast());  // 30
    
//             // Removing elements
//             System.out.println("Removed front: " + deque.removeFirst()); // 5
//             System.out.println("Removed rear: " + deque.removeLast());   // 30
    
//             System.out.println("Front element after removal: " + deque.peekFirst()); // 10
//             System.out.println("Deque size: " + deque.size()); // 2
//         }
//     }
// }






//Leet Code 994

import java.util.LinkedList;
import java.util.Queue;

public class Additional {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Step 1: Add initial rotten oranges to the queue and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // Add rotten orange to the queue
                } else if (grid[i][j] == 1) {
                    freshOranges++; // Count fresh oranges
                }
            }
        }

        // If there are no fresh oranges, return 0
        if (freshOranges == 0) return 0;

        // Directions for moving up, down, left, right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int minutes = 0;

        // Step 2: BFS to rot adjacent fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    // Check if the adjacent cell is within bounds and is a fresh orange
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        // Rot the orange
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                        freshOranges--; // Decrease the count of fresh oranges
                        rottedThisMinute = true;
                    }
                }
            }

            // Increment minutes only if at least one orange rotted in this cycle
            if (rottedThisMinute) minutes++;
        }

        // Step 3: Check if there are any fresh oranges left
        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        Additional solution = new Additional();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(solution.orangesRotting(grid)); // Output: 4
    }
}