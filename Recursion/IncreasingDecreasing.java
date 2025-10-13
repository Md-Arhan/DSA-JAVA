package Recursion;

public class IncreasingDecreasing {
    public static void decreasingOrder(int n){
        if(n==0){
            return;
        }

        System.out.print(n + " ");
        decreasingOrder(n-1);
    }

    public static void increasingOrder(int n){
        if (n==0) {
            return;
        }
        increasingOrder(n-1);
        System.out.print(n + " ");
    }

    public static void main(String []args){
     int n = 10;

     decreasingOrder(n);
     System.out.println();
     increasingOrder(n);
    }
}
