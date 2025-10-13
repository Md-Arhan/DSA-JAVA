package DP;

// import java.util.*;

//Tribonacci Series

// public class Assignment {

//     public static int tribonacci(int n, int dp[]){
//         if (n==0) {
//             return 0;
//         }

//         if (n==1 || n==2) {
//             return 1;
//         }

//         if (dp[n] != -1) {
//            return dp[n];
//         }

//         dp[n] = tribonacci(n-1, dp) + tribonacci(n-2, dp) + tribonacci(n-3, dp);
//         return dp[n];
//      }
  
//     public static void main(String[] args) {
//         int n = 5;
//         int dp[] = new int[n+1];
//         Arrays.fill(dp, -1);
//         System.out.println(tribonacci(n, dp));

//     }    
// }




//Valid Parenthesis

// public class Assignment {

//     public static void helper(int open, int close, String str, int n, List<String> ans){
//         if (open == n && close == n) {
//             ans.add(str);
//             // System.out.print(str);
//             return;
//         }

//         if (open < n) {
//             helper(open+1, close, str +"(", n, ans);
//         }

//         if (close < open) {
//             helper(open, close+1, str +")", n, ans);
//         }
//     }

//     public static List<String> generateParenthesis(int n){
//         List<String> ans = new ArrayList<>();
//         int open = 0;
//         int close = 0;
//         helper(open, close, "", n, ans);
//         return ans;
//     }    

//     public static void main(String[] args) {
//         int n = 3;
//         List<String> res = generateParenthesis(n);
//         System.out.println(res);
//     }
// }



// Buying ans Selling the Stocks and paying the fee

// public class Assignment {

//     public static int stocks(int index, boolean isTrue, int n, int prices[], int fee){
//         if(index == n){
//             return 0;
//         }

//         if (isTrue == false) {
//             int buy = -prices[index] + stocks(index+1, true, n, prices, fee);
//             int skip = stocks(index+1, isTrue, n, prices, fee);
//             return Math.max(skip, buy);
//         }else{
//             int sell = prices[index] - fee  + stocks(index+1, false, n, prices, fee);
//             int notSell = stocks(index+1, true, n, prices, fee);
//             return Math.max(sell, notSell);
//         }
//     }

//     public static void main(String[] args) {
//        int prices[] = {7, 1, 5, 3, 6, 4};
//        boolean isTrue = false;
//        int n = prices.length;
//        int fee = 2;

//        System.out.println(stocks(0, isTrue, n, prices, fee));


//     }



// Longest Palindrome subsequence

// public class Assignment {

//     public static int lcs(String s1, String s2, int n, int m){
//         if (n==0 || m==0) {
//             return 0;
//         }

//         if (s1.charAt(n-1) == s2.charAt(m-1)) {
//             return lcs(s1, s2, n-1, m-1) + 1;
//         }else{
//             int ans1 = lcs(s1, s2, n-1, m);
//             int ans2 = lcs(s1, s2, n, m-1);
//             return Math.max(ans1, ans2);
//         }
//     }
    
//     public static void main(String[] args) {
//         String str1 = "bbbab";
//         String str2 = new StringBuilder(str1).reverse().toString();
//         System.out.println(lcs(str1, str2, str1.length(), str2.length()));
//     }
// }




//Equal Subset Sum

public class Assignment {

    public static boolean subSetSum(int arr[], int target, int n){
        // Base case: if the target is 0, we found a subset
        if (target == 0) {
            return true;
        }
        // Base case: if no elements left but target is not met
        if (n == 0) {
            return false;
        }

        // If the current element is greater than the target, ignore it
        if (arr[n - 1] > target) {
            return subSetSum(arr, target, n - 1);
        }

        // Either include the element or exclude it
        return subSetSum(arr, target - arr[n - 1], n - 1) || subSetSum(arr, target, n - 1);
    }

    public static boolean equalSubset(int arr[], int n){
        int sum = 0;
        for(int i=0; i<n ; i++){
            sum+=arr[i];
        }

        if (sum%2!=0) {
            return false;
        }

        int target = sum/2;
        return subSetSum(arr, target, n);
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 7, 11};
        int target = 12;
        int n = arr.length;
        System.out.println(subSetSum(arr, target, n));
        System.out.println(equalSubset(arr, n));
        }
}