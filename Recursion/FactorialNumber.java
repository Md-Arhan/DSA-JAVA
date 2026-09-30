package Recursion;

public class FactorialNumber {
    public static int factorial(int n){
        if(n==0){
            return 1;
        }

        int fnm1 = factorial(n-1);
        int fn = n* fnm1;
        return fn;
    }

    public static int factorialTab(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = i * dp[i - 1];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n =2 ;
        System.out.println(factorial(n));
    }
}
