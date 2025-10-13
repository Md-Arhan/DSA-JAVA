package Recursion;

public class NaturalNumber {
    public static int nNatural(int n){
        if(n==0){
            return 0;
        }
        int frstN = nNatural(n-1);
        int fn = n + frstN;
        return fn;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(nNatural(n));
    }
}
