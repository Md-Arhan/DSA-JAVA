package Recursion;

public class PowerofN {
    public static int pow(int x, int n){
        if(n==0){
            return 1;
        }
        // int xnm1 =  pow(x, n-1);
        // int xn = x * xnm1;

        return x * pow(x, n-1);
    }

    public static int optimezedPow(int x, int n){
        if(n==0){
            return 1;
        }

        int halfPow =optimezedPow(x, n/2);
        int halfPowsq = halfPow * halfPow;
        System.out.println(halfPowsq);

        if(n % 2 !=0){
            halfPowsq = x * halfPowsq;
        }

        return halfPowsq;
    }

    public static void main(String []args){
      int x = 2;
      int n = 10;
      System.out.println(optimezedPow(x, n));
      System.out.println(pow(10, 2));
    }
}



/*
 * Call Stack	x	n	Condition (n == 0)	halfPow	halfPowsq	Returned Value
optimezedPow(2,5)	2	5	No	optimezedPow(2,2)	(later computed)	?
optimezedPow(2,2)	2	2	No	optimezedPow(2,1)	(later computed)	?
optimezedPow(2,1)	2	1	No	optimezedPow(2,0)	(later computed)	?
optimezedPow(2,0)	2	0	Yes (Base Case)	1	1	1
 */


 /*
  * Returning Phase (Unwinding the Recursion Stack):
optimezedPow(2,0) → returns 1
optimezedPow(2,1):
halfPow = 1
halfPowsq = 1 * 1 = 1
Since n is odd (1), halfPowsq = 2 * 1 = 2
Returns 2
Prints 1 (before modifying for odd case)
optimezedPow(2,2):
halfPow = 2
halfPowsq = 2 * 2 = 4
Since n is even (2), no modification.
Returns 4
Prints 4
optimezedPow(2,5):
halfPow = 4
halfPowsq = 4 * 4 = 16
Since n is odd (5), halfPowsq = 2 * 16 = 32
Returns 32
Prints 16

  */