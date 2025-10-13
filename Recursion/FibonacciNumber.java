package Recursion;

public class FibonacciNumber {
    public static int fibonacci(int n){
        if (n == 0) {
            return 0;
        }
        if(n==1){
            return 1;
        }

        int frstTerm = fibonacci(n-1);
        int secTerm = fibonacci(n-2);
        int nthTerm = frstTerm + secTerm;
        return nthTerm;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fibonacci(n));
    }
}
