package DP.LongestCommonSubsequence;

public class Recurssion {

    public static int lcs(String s1, String s2, int n, int m){
        if (n==0 || m==0) {
            return 0;
        }

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return lcs(s1, s2, n-1, m-1) + 1;
        }else{
            int ans1 = lcs(s1, s2, n-1, m);
            int ans2 = lcs(s1, s2, n, m-1); 
            return Math.max(ans1, ans2);
        }
    }
    
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
    }
}


/*
 * What is a subsequence?
A subsequence is a sequence you can form from a string or array by deleting some (or no) elements, without changing the order of the remaining elements.
It does not need to be contiguous, but must maintain relative order.
💡 Longest Common Subsequence (LCS)
When comparing two strings (or arrays), the Longest Common Subsequence (LCS) is:
The longest sequence that appears as a subsequence in both.
✅ Key Rules:
Order must be preserved
Skips are allowed
Does not need to be contiguous
 */


/*
 * String s1 = "";
s1 += 'a';  // s1 = "a"     → copies 1 char
s1 += 'b';  // s1 = "ab"    → copies 2 chars
s1 += 'c';  // s1 = "abc"   → copies 3 chars
Total characters copied = 1 + 2 + 3 = 6 → O(n²)
at every moment it creates a new object of string and later it combines
 */


/*
 * s1 = new StringBuilder(s1).append(s.charAt(i)).toString();
That means:

A new StringBuilder is created from the current s1.

The character s.charAt(i) is appended to that builder.

The result is converted back to a String via .toString().

This new String replaces the old s1.
 */