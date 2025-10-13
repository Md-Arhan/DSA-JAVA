package DP.ClimbingStairs;

public class Recurssion {

    public static int climbingStairs(int n){
        if (n==0) {
            return 1;
        }else if (n < 0) {
            return 0;
        }

        return climbingStairs(n-1) + climbingStairs(n-2) + climbingStairs(n-3);
    }
    
    public static void main(String[] args) {
        int n = 1000;
        System.out.println(climbingStairs(n));

    }
}
