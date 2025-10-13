package Stacks;

import java.util.*;;

/*Forms
 * 1.next greater right  (i=n; i>=0; i--)(<=)
 * 2.next greater left   (i=0; i<n; i++) (<=)
 * 3.next smallest right (i=n; i>=0; i--)(>=)
 * 4.next smaller left   (i=0; i<n; i++) (>=)
 */

/*
 * Time Complexity: O(n)
   The for loop runs n times.

   Inside it, each element is pushed once and popped once → O(n) total stack operations.
 */

public class NextGreater {
    public static void main(String[] args) {
        int arr[] = { 10, 6, 2, 3, 1 };
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // 1st while
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // 2 if-else
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }

            // 3 push in s
            s.push(i);

        }

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();
    }
}
