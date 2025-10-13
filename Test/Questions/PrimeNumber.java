package Test.Questions;

import java.util.Arrays;

public class PrimeNumber {

    public static boolean isPrime(int n) {
        for (int i = 2; i <= (Math.sqrt(n)); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void primeInRange(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i) == true) {
                System.out.println(i);
            }
        }
    }

        static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= n; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }
        
        return isPrime;
    }


    /*
     * How to explain in an interview
     * "Instead of testing each number for primality, the Sieve of Eratosthenes
     * eliminates non-primes by marking multiples of known primes.
     * We only need to loop till √N and start marking from p² because smaller
     * multiples are already handled.
     * This algorithm has O(N log log N) time complexity, making it one of the
     * fastest ways to generate all primes up to N."
     */

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // sc.close();
        int n = 1;

        if (n == 2) {
            System.out.println("Prime Number");
        } else {
            boolean isTrue = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    isTrue = false;
                }
            }
            if (isTrue) {
                System.out.println("Prime Numeber");
            } else {
                System.out.println("Not a Prime Number");
            }
        }
    }
}

/*
 * static boolean isPrime(int n) {
 * if (n <= 1) return false;
 * if (n == 2) return true;
 * if (n % 2 == 0) return false;
 * 
 * for (int i = 3; i * i <= n; i += 2) {
 * if (n % i == 0) return false;
 * }
 * 
 * return true;
 * }
 * 🔁 Dry Run for n = 11:
 * Step 1:
 * n = 11
 * n <= 1 → false
 * n == 2 → false
 * n % 2 == 0 → false (11 is odd)
 * 
 * Step 2:
 * Start loop: for (int i = 3; i * i <= n; i += 2)
 * 
 * i i * i Condition i * i <= 11 11 % i == 0? Result
 * 3 9 ✅ 9 ≤ 11 11 % 3 = 2 continue
 * 5 25 ❌ 25 > 11 — stop loop
 * 
 * 
 * What You’re Learning Is a Prime Checking Technique
 * This is not just random code — it’s a well-known and optimized technique for
 * checking if a number is prime, used in coding interviews and competitive
 * programming.
 * ⚙️ The Technique (Step-by-Step Logic):
 * Reject numbers ≤ 1 – because they’re not prime.
 * Accept 2 as a prime – it's the only even prime.
 * Reject even numbers > 2 – they’re not prime (because divisible by 2).
 * Loop from 3 to √n, checking only odd numbers – this avoids unnecessary
 * checks.
 * We use i * i <= n instead of i <= sqrt(n) to avoid slow square root
 * calculations.
 * We skip even numbers by doing i += 2 instead of i++.
 * If any i divides n, it’s not prime → return false.
 * If no divisor is found, return true (it's prime).
 */

/*
 * Sieve : A sieve is a famous and super-efficient technique used to find all
 * prime numbers up to a given number n.
 * 
 * How the Sieve of Eratosthenes Works (Step-by-Step):
 * Let’s say n = 30
 * We want to find all prime numbers ≤ 30.
 * Create a boolean array isPrime[0…n], initialized to true.
 * Set isPrime[0] = false and isPrime[1] = false (since 0 and 1 are not prime).
 * Start from p = 2 (the first prime).
 * For each number p:
 * If isPrime[p] == true:
 * Mark all multiples of p as false (i.e., not prime): p*p, p*p + p, p*p + 2p,
 * ..., up to n.
 * Continue for p = 3, 4, 5, ..., √n.
 * 
 * 
 * 
 * 
 * [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 30] → all marked true
 * Start from 2:
 * Mark 4, 6, 8, 10, ..., 30 as false
 * Next is 3:
 * Mark 9, 12, 15, ..., 30 as false
 * Next is 4 (but 4 is already false — skip it)
 * Next is 5:
 * Mark 25, 30 as false
 * Stop at √30 ≈ 5.4 → Done
 * Remaining true values in array = all prime numbers ≤ 30
 */

/*
 * Main :
 * 
 * Why is it safe to stop after 3?
 * Because:
 * Any divisor larger than √13 (~3.6) must be paired with a smaller divisor.
 * Example: If 13 = a × b and a > 3.6, then b < 3.6.
 * We already checked all numbers ≤ 3.6 (i = 2, 3).
 * Since we found no divisor, 13 cannot be composite.
 * 
 * Example with n = 36:
 * Factors of 36:
 * (1, 36), (2, 18), (3, 12), (4, 9), (6, 6), (9, 4), (12, 3), (18, 2), (36, 1)
 * Notice:
 * After 6 × 6, the pairs just start repeating in reverse:
 * 4 × 9 becomes 9 × 4
 * 3 × 12 becomes 12 × 3
 * √36 = 6.
 * So once we check all numbers up to 6, we have already covered all factor
 * combinations.
 * There is no need to check beyond 6.
 * 
 * Key idea:
 * For 13, the possible divisors to test are only 2 and 3.
 * After that, you can be 100% sure it’s prime.
 * 
 * we are taking the sqrt if it is found between the sqrt number than it is
 * possible or else not
 */

/*
 * 1. Start with the naive idea
 * "To check if a number n is prime, the simplest way is to try dividing it by
 * every number from 2 to n-1.
 * But this is O(n), which is inefficient for large n."
 * 
 * 2. Then explain the optimization (√n)
 * "We can optimize this by observing that factors always appear in pairs:
 * if n = a × b, one of a or b must be less than or equal to √n.
 * If we don’t find any factor up to √n, there’s no factor beyond that either.
 * So we only need to check divisors from 2 up to √n, which makes it O(√n)."
 * 
 * Example:
 * For 36, factor pairs are (2,18), (3,12), (4,9), (6,6).
 * Notice: Once we pass 6 (√36), all larger factors are already paired with
 * smaller ones.
 */