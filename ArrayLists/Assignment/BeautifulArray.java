package Assignment;

import java.util.ArrayList;

/*A Beautiful Array is an array that satisfies the following conditions:

Permutation: It contains all integers from 1 to 𝑛  exactly once, but the order can be any arrangement.
No Midpoint Property: For any two elements in the array, there is no third element in between them that is the exact arithmetic midpoint. */

public class BeautifulArray {

    /*
     * Iteration 1
     * Even Numbers:
     * 
     * 2 * 1 = 2 (≤ 5) ✅ → temp = [2]
     * 
     * Odd Numbers:
     * 
     * 2 * 1 - 1 = 1 (≤ 5) ✅ → temp = [2, 1]
     * 
     * Updated ans:
     * ans = [2, 1]
     * 
     * 
     * Iteration 2
     * Even Numbers:
     * 
     * 2 * 2 = 4 (≤ 5) ✅ → temp = [4]
     * 
     * 2 * 1 = 2 (≤ 5) ✅ → temp = [4, 2]
     * 
     * Odd Numbers:
     * 
     * 2 * 2 - 1 = 3 (≤ 5) ✅ → temp = [4, 2, 3]
     * 
     * 2 * 1 - 1 = 1 (≤ 5) ✅ → temp = [4, 2, 3, 1]
     * 
     * Updated ans:
     * ans = [4, 2, 3, 1]
     * 
     */

    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            // Add Even Numbers
            for (Integer e : ans) {
                if (2 * e <= n) {
                    temp.add(e * 2);
                }
            }
            // Add Odd Numbers
            for (Integer e : ans) {
                if (2 * e - 1 <= n) {
                    temp.add(e * 2 - 1);
                }
            }
            ans = temp;
        }
        return ans;
    }

    public static ArrayList<Integer> beautifulArrayDC(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        divideConquer(1, 1, res, n);
        return res;
    }

    public static void divideConquer(int start, int increment, ArrayList<Integer> res, int n) {

        if (start + increment > n) {
            res.add(start);
            return;
        }

        divideConquer(start, 2 * increment, res, n);
        divideConquer(start + increment, 2 * increment, res, n);
    }

    public static void main(String[] args) {
        ArrayList<Integer> res = beautifulArrayDC(5);
        System.out.println(res);
    }
}

/*
 * Optimized Approach: Divide and Conquer
 * We can recursively construct the array by:
 * 
 * Splitting numbers into two groups:
 * 
 * Odd-indexed numbers → Keeps the permutation diverse.
 * 
 * Even-indexed numbers → Ensures no arithmetic progression is formed.
 * 
 * Merging them together to maintain the "beautiful" property.
 * 
 * Algorithm Steps:
 * Start with n = 1, which is already a beautiful array.
 * 
 * Recursively build the array for n:
 * 
 * Construct left half using odd numbers from a beautiful array of n/2.
 * 
 * Construct right half using even numbers from a beautiful array of n/2.
 * 
 * Merge both halves.
 */