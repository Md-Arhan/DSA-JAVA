package DP.TargetSumSubset;

public class Recursion {

    public static boolean recurssion(int arr[], int target, int n){

        if (n == 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }

        int v = arr[n];

       if (v<=target) {
         if (recurssion(arr, target-v, n-1)) {
            return true;
         }
       }

        return recurssion(arr, target, n-1);
        
    }
    
    public static void main(String[] args) {
        int arr[] = {4, 2, 7, 1, 3};
        int target = 20;
        int n = arr.length-1;
        System.out.println(recurssion(arr, target, n));
    }
}
