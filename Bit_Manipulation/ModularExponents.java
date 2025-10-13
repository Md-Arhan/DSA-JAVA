public class ModularExponents {
    public static long modExp(long a, long b, long m) {
        long result = 1;
        a = a % m; // Reduce base if larger than mod

        while (b > 0) {
            if ((b & 1) == 1) { // If b is odd
                result = (result * a) % m;
            }
            a = (a * a) % m; // Square base
            b >>= 1; // Divide b by 2
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(modExp(3, 5, 7));
    }
}

/* Important */

/*

Yes! 1140 is not just a random number—it appears in modular arithmetic and cryptography because of Euler's theorem and totient function. Here's why it's special:

1. 1140 is Often Used in Euler’s Theorem
Euler’s theorem states:
𝑚a ϕ(m) ≡1modmwhere 𝜙(𝑚)ϕ(m) is Euler’s totient function, which counts numbers coprime to 𝑚m.

We calculated earlier that:𝜙(1140)=
288
ϕ(1140)=288
This means:
𝑎288≡1mod
 
 
1140
a 
288
 ≡1mod1140
This helps in reducing large exponents mod 1140, which is why you saw mod 1140 in the code.

2. 1140 is a Highly Composite Number
1140 has a lot of divisors, making it useful in modular calculations.

Prime Factorization of 1140:
1140=2^2×3×5×19 
1140=2^2×3×5×19
It has divisors:
1, 2, 3, 4, 5, 6, 10, 12, 15, 19, 20, 30, 38, 57, 60, 95, 114, 190, 228, 285, 380, 570, 1140

Why does this matter?

Since 1140 has many factors, it works well with modular arithmetic operations.

It often appears in Euler's theorem problems because of how 
𝜙
(
1140
)
ϕ(1140) simplifies calculations.



*/


class Solution {

    public long calPow(int a, long pow, int mod) {
        long result = 1;
        a = a % mod; // Reduce base if larger than mod

        while (pow > 0) {
            if ((pow & 1) == 1) { // If pow is odd
                result = (result * a) % mod;
            }
            a = (a * a) % mod; // Square base
            pow >>= 1; // Divide pow by 2
        }

        return result;
    }

    public int superPow(int a, int[] b) {
        int mod = 1337;
        long pow = 0;

        // Compute b % 1140 using modular reduction (Euler's Theorem): For specific problem we use 1140 to reduce the exponential number
        for (int digit : b) {
            pow = (pow * 10 + digit) % 1140;
        }

        // Handle edge case: if pow becomes 0, set it to 1140
        if (pow == 0) {
            pow = 1140;
        }

        return (int) calPow(a, pow, mod);
    }
}

/*
 * Modular exponentiation and fast exponentiation are related techniques used to
 * compute large exponentiations efficiently, especially in cryptography and
 * number theory.
 * 
 * Modular Exponentiation
 * 
 * It computes:
 * 
 * C = (A^B) \mod M
 * 
 * is the base,
 * 
 * is the exponent,
 * 
 * is the modulus.
 * 
 * 
 * Instead of computing first (which can be extremely large) and then taking
 * modulo , modular exponentiation uses efficient methods to compute the result
 * without overflow.
 * 
 * Fast Exponentiation (Exponentiation by Squaring)
 * 
 * This is a method to compute efficiently using divide-and-conquer. It reduces
 * the number of multiplications from O(B) (naïve method) to O(log B).
 * 
 * Algorithm (Iterative Version)
 * 
 * 1. Initialize result = 1
 * 
 * 
 * 2. While B > 0:
 * 
 * If B is odd: result = (result * A) % M
 * 
 * Update A = (A * A) % M
 * 
 * Update B = B // 2
 * 
 * 
 * 
 * 3. Return result
 * 
 * 
 * 
 * Example
 * 
 * Calculate :
 * 
 * Thus, .
 * 
 * This method is widely used in cryptographic algorithms like RSA. Let me know
 * if you need a code implementation!
 */






 
/*
 * Key Signs
 * 🔍 Key Signs of a Modular Exponentiation Question
 * 1️⃣ Presence of "mod" in the problem statement
 * 🔸 If a question asks for "result modulo m", it’s a clear indicator.
 * ✅ Example:
 * 
 * "Find
 * 2
 * 1000
 * m
 * o
 * d
 * 
 * 
 * 7
 * 2
 * 1000
 * mod7"
 * 
 * 2️⃣ Large Exponent (b)
 * 🔸 If
 * 𝑏
 * b is very large, direct computation of
 * 𝑎
 * 𝑏
 * a
 * b
 * isn't feasible.
 * ✅ Example:
 * 
 * "Compute
 * 5
 * 123456789
 * m
 * o
 * d
 * 
 * 
 * 1000000007
 * 5
 * 123456789
 * mod1000000007"
 * 
 * 🚨 Warning: Directly computing
 * 5
 * 123456789
 * 5
 * 123456789
 * will cause overflow! We must use modular exponentiation.
 * 
 * 3️⃣ Exponent Given as an Array
 * 🔸 Instead of b being an integer, it's given as an array of digits.
 * ✅ Example:
 * 
 * java
 * Copy
 * Edit
 * a = 3, b = [1, 0, 0, 0], m = 7
 * Here,
 * 𝑏
 * =
 * 1000
 * b=1000, but storing it as an integer causes overflow.
 * 
 * Solution: Compute
 * 𝑏
 * m
 * o
 * d
 * 
 * 
 * (
 * 𝑚
 * −
 * 1
 * )
 * bmod(m−1) and apply modular exponentiation.
 * 
 * 4️⃣ Constraints on Time Complexity
 * 🔸 If the problem constraints make brute-force exponentiation impossible,
 * it's a hint.
 * ✅ Example:
 * 
 * "Compute
 * (
 * 12345
 * 678910
 * )
 * m
 * o
 * d
 * 
 * 
 * 999983
 * (12345
 * 678910
 * )mod999983 efficiently"
 * Brute force
 * 𝑂
 * (
 * 𝑏
 * )
 * O(b) won’t work! Need O(log b) using Exponentiation by Squaring.
 */