package Queue;

import java.util.*;

public class MaxSubArray_SlidingWindow {

    public static void maxSubArray(int arr[], int k) {
        Deque<Integer> d = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            // Remove elements that are out of this window
            while (!d.isEmpty() && d.peek() <= i - k) {
                d.removeFirst();
            }

            // Remove all smaller elements in the current window
            while (!d.isEmpty() && arr[i] >= arr[d.peekLast()]) {
                d.removeLast();
            }

            d.addLast(i);

            // Print the max (front of deque) once the first window is formed

            if (i >= k - 1) {
                System.out.print(arr[d.peek()] + " ");
            }
        }
    }

    // public static void maximumSubArray(int arr[], int k) {
    //     Deque<Integer> d = new LinkedList<>();

    //     // Process the first k elements
    //     for (int i = 0; i < k; i++) {
    //         // Remove smaller elements from the back of deque
    //         while (!d.isEmpty() && arr[i] >= arr[d.peekLast()]) {
    //             d.removeLast();
    //         }
    //         d.addLast(i);
    //     }

    //     // Process the rest of the array
    //     for (int i = k; i < arr.length; i++) {
    //         // The element at the front of the deque is the maximum for the previous window
    //         System.out.print(arr[d.peek()] + " ");

    //         // Remove elements that are out of this window
    //         while (!d.isEmpty() && d.peek() <= i - k) {
    //             d.removeFirst();
    //         }

    //         // Remove all smaller elements in the current window
    //         while (!d.isEmpty() && arr[i] >= arr[d.peekLast()]) {
    //             d.removeLast();
    //         }

    //         // Add the current element index to the deque
    //         d.addLast(i);
    //     }

    //     // Print the maximum for the last window
    //     // System.out.print(arr[d.peek()]);
    // }

    public static void main(String[] args) {
        int arr[] = { 6, 10, 4, 7, 2, 4 };
        // maximumSubArray(arr, 3);
        maxSubArray(arr, 3);

    }
}



/*
 * How the sliding window shifts:
We’ll show this with the window and calculation of i - k, along with which indices are removed.

i = 0
Window: [6]

i - k = 0 - 3 = -3 → deque is empty, nothing removed

Deque: [0]

i = 1
Window: [6, 10]

i - k = 1 - 3 = -2 → deque front = 0 → not out of window

Deque: [1] (0 removed because 10 > 6)

i = 2
Window: [6, 10, 4]

i - k = 2 - 3 = -1 → deque front = 1 → not out of window

Deque: [1, 2]

Now window is full → max = arr[1] = 10

i = 3
Window: [10, 4, 7]

i - k = 3 - 3 = 0

Deque front = 1 → still in window (index 1 > 0), keep it

Remove 2 (4 < 7)

Add 3

Deque: [1, 3]

max = arr[1] = 10

i = 4
Window: [4, 7, 2]

i - k = 4 - 3 = 1

Deque front = 1 → index = 1 == i - k → remove 1 (out of window)

Deque becomes [3, 4]

max = arr[3] = 7

i = 5
Window: [7, 2, 4]

i - k = 5 - 3 = 2

Deque front = 3 → still in window (3 > 2)

Remove 4 (arr[4] = 2 < arr[5] = 4)

Add 5

Deque: [3, 5]

max = arr[3] = 7


 */




 /*
  * Why O(n), not O(n * k)?
Even though there are two while loops inside the for loop, each element is:
Added to the deque at most once, and
Removed from the deque at most once
So over the course of the entire loop:
Each element is pushed and popped from the deque once
Total number of operations is proportional to n
Hence, the algorithm runs in linear time: O(n)

Space Complexity: O(k)
The deque holds at most k indices at a time (size of the window)
So space complexity is O(k)
Let me know if you'd like a visual dry run to reinforce this!
  */