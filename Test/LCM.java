package Test;

public class LCM {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Function to calculate LCM
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);     // a / gcd(a, b) * b; overflow handler
    }

    public static void main(String[] args) {
        int a = 12;
        int b = 18;

        System.out.println(gcd(6, 4));

        // System.out.println("LCM of " + a + " and " + b + " is " + lcm(a, b));
    }
}



// LCM (lowest common divisor) : use to find the common divisor between numbers

// HCF (Highest common factor)largest number which exactly divides two or more numbers
/*Example: 12 and 18

so for the calls we are making divident as divisor for next call and divsor is remainder of a% b
The old divisor (b) becomes the new dividend
The remainder (r) becomes the new divisor

Divisors of 12 → 1, 2, 3, 4, 6, 12
Divisors of 18 → 1, 2, 3, 6, 9, 18  = 6
 */

// divisor × quotient + remainder

/*
 * Step-by-step:

1️⃣ Divide 4 by 3
→ 4÷3=1 (quotient = 1, because 3 fits into 4 one time)

2️⃣ Multiply quotient × divisor
→ 1×3=3

3️⃣ Subtract from dividend
→ 4−3=1

✅ Remainder = 1
 */