package Test.Patterns.DiamondPattern;

public class DmEmptyInside {

    public static void daimondPattern(int n) {
        int spaces = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            if (i == 1) {
                System.out.print("*");
            } else {
                System.out.print("*");
                for (int k = 0; k < spaces; k++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                spaces += 2;
            }
            System.out.println();
        }

        // Middle row printed twice correctly (without decrementing spaces first)
        System.out.print("*");
        for (int k = 0; k < spaces; k++) {
            System.out.print(" ");
        }
        System.out.print("*");
        System.out.println();

        // Reset spaces for 2nd half (decrement only once)
        spaces -= 2;

        // 2nd Half (Lower Pyramid)
        for (int i = n - 1; i >= 1; i--) {
            // Print leading spaces
            for (int j = n - i; j >= 1; j++) {
                System.out.print(" ");
            }

            if (i == 1) {
                System.out.print("*");
            } else {
                System.out.print("*");
                for (int k = 0; k < spaces; k++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                spaces -= 2;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        daimondPattern(5);
    }
}