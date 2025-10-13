package Test.Patterns;

public class PrintStars {
    public static void main(String[] args) {
        int N = 5, spaces = 1;
        for (int row = 1; row <= (2 * N) - 1; row++) {
            // Print empty spaces before printing the stars
            if (row <= N) {
                // Print (N-row) spaces
                for (int j = 0; j < N - row; j++) {
                    System.out.print(" ");
                }
            } else {
                // Print row-N spaces
                for (int j = 0; j < row - N; j++) {
                    System.out.print(" ");
                }
            }

            // Print the stars
            if (row == 1 || row == (2 * N - 1)) {
                // we have to print only 1 star
                System.out.print("*");
            } else {
                // We have to print 2 stars with spaces in between
                // Print the stars along with spaces
                System.out.print("*");

                // Print empty spaces
                for (int j = 0; j < spaces; j++) {
                    System.out.print(" ");
                }

                // Print another star
                System.out.print("*");

                // Now our row is done.
                if (row < N) {
                    spaces += 2;
                } else {
                    spaces -= 2;
                }
            }
            System.out.println();
        }
    }
}
