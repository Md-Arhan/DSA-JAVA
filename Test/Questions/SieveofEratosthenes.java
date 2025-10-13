package Test.Questions;
import java.util.*;

public class SieveofEratosthenes {

    public static int countPrimes(int n) {
        if (n < 2) return 0; // No primes below 2

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true); // Assume all numbers are prime
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i < n; i++) { // Only iterate up to sqrt(n)
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) { // Mark multiples of i as non-prime
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 499979;
        System.out.println(countPrimes(n)); // Expected output: Number of primes less than 499979
    }
}
