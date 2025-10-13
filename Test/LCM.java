package Test;

public class LCM {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Function to calculate LCM
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int a = 12;
        int b = 18;

        System.out.println("LCM of " + a + " and " + b + " is " + lcm(a, b));
    }
}
