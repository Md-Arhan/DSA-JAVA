package Test.Patterns.DiamondPattern;

public class DmPrintingNumbers {
    public static void main(String[] args) {
        int N = 5;
        for (int i = 1; i <= N; i++) {
            // Step 1. Print empty spaces
            for (int j = 0; j < (N - i); j++) {
                System.out.print(" ");
            }

            // Step 2. Start printing the numbers
            int number = 1;
            // boolean increasing = true;
            // while (number > 0) {
            // System.out.print(number);
            // if (number == i) {
            // increasing = false;
            // }
            // if (increasing == true) {
            // number++;
            // } else {
            // number--;
            // }
            // }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print(number);
                if (j < i) {
                    number++;
                } else {
                    number--;
                }
            }
            System.out.println();
        }
    }
}
