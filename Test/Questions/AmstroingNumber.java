package Test.Questions;

import java.util.*;

public class AmstroingNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int num = n;
        int sumofidg = 0;

        while (n != 0) {
            int digit = n % 10;
            n = n / 10;
            sumofidg += digit * digit * digit;
        }
        System.out.println(sumofidg);
        if (sumofidg == num) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}
