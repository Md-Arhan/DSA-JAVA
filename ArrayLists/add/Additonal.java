package add;
// package ArrayLists;

// import java.util.*;

// public class additional {
//     class MyArrayList<T> {
//         private T[] data;       // Array to store elements
//         private int size;       // Current number of elements
//         private static final int DEFAULT_CAPACITY = 10; // Default initial capacity

//         // Constructor
//         public MyArrayList() {
//             data = (T[]) new Object[DEFAULT_CAPACITY]; // Initializing with default capacity
//             size = 0;
//         }

//         // Add element to the list
//         public void add(T element) {
//             ensureCapacity(); // Ensure enough capacity before adding
//             data[size++] = element;
//         }

//         // Get element at a specific index
//         public T get(int index) {
//             checkIndex(index);
//             return data[index];
//         }

//         // Remove element at a specific index
//         public T remove(int index) {
//             checkIndex(index);
//             T removedElement = data[index];
//             // Shift elements to the left to fill the gap
//             for (int i = index; i < size - 1; i++) {
//                 data[i] = data[i + 1];
//             }
//             data[--size] = null; // Clear the last element
//             return removedElement;
//         }

//         // Get the current size of the list
//         public int size() {
//             return size;
//         }

//         // Ensure the array has enough capacity, double its size if needed
//         private void ensureCapacity() {
//             if (size == data.length) {
//                 T[] newData = (T[]) new Object[data.length * 2]; // Double the size
//                 System.arraycopy(data, 0, newData, 0, data.length); // Copy old data
//                 data = newData;
//             }
//         }

//         // Check if the index is valid
//         private void checkIndex(int index) {
//             if (index < 0 || index >= size) {
//                 throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
//             }
//         }
//     }
// }

// public class Additonal {
//     public static void main(String[] args) {
//         List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

//         // Creating a stream, filtering even numbers, squaring them, and printing the
//         // result
//         numbers.stream() // 1. Convert list to stream
//                 .filter(n -> n % 2 != 0) // 2. Filter odd numbers (remove even)
//                 .map(n -> n * n) // 3. Square each remaining number
//                 .forEach(System.out::println); // 4. Print each result
//     }
// }