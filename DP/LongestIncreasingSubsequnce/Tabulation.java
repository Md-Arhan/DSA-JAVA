package DP.LongestIncreasingSubsequnce;

import java.util.Arrays;
import java.util.HashSet;

public class Tabulation {

    public static int lcs(int arr[], int arr2[]){
        int n = arr.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];

        //Initialization
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                dp[i][j] = 0;
             }
        }

        //Bottom up
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if (arr[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];

    }

    public static int lis(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        int n = arr.length;
        for(int i=0; i<n; i++){   //O(n)
            set.add(arr[i]);
        }

        int arr2[] = new int[set.size()];
        int i=0;
        for (int num : set) {    //O(n)
            arr2[i] = num;
            i++;
        }

        Arrays.sort(arr2);  //Ascending Order Sorting   O(n*logn)

        return lcs(arr, arr2);   //O(n * m)
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 3, 1};
        System.out.println(lis(arr));
    }
}



/*
 *  Core Idea
Observation:
The Longest Increasing Subsequence (LIS) of an array is the Longest Common Subsequence between:
The original array
And the sorted version of the array with duplicates removed
🧠 Why This Works
LIS requires elements to be increasing and in original order.
Sorting the array gives the correct increasing order.
LCS helps us preserve the original order of the elements while matching them to the increasing version.

🧑‍🏫 How to Explain in Interview
“I solved LIS by converting it into an LCS problem. The trick is to compare the original array with a sorted, unique version of itself. The Longest Common Subsequence between these two arrays gives the Longest Increasing Subsequence in the original. I used dynamic programming to compute LCS in O(n²) time.”
 */


/*LCS:
 * Definition of Subsequence:
A subsequence is a sequence that can be derived from another sequence by deleting zero or more elements without changing the order of the remaining elements.
For example, in string "abcde", the subsequences include:
"a", "ae", "abc", "bce", "ace" etc.
✅ LCS Requirements:
Must appear in both sequences.
Must maintain the original relative order in each.
Can skip characters, but can’t rearrange.
 */


/*
Trick Idea: Use LCS (Longest Common Subsequence)
We convert LIS into an LCS problem by doing the following:

🔁 Steps:
Copy the original array.
Sort that copy.
Remove duplicates from that sorted array.
Perform LCS(nums, sortedUnique(nums)).
The LCS between the original array and the sorted unique array gives the LIS
 * The Longest Common Subsequence (LCS) between two sequences is the longest sequence that appears in both sequences in the same order, but not necessarily contiguously.
 * LCS is the longest sequence of letters or numbers that:
✅ Appears in both sequences (strings or arrays)
✅ In the same order
❌ But they don’t have to be next to each other (contiguous)
*/