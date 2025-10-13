package Test.Questions;

import java.util.Scanner;

public class ReverseNumber {
    // print reverse of a number

    public static void reverNumber(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int rev = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            rev = (rev * 10) + lastDigit;
            n = n / 10;
        }
        System.out.println(rev);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        while (n > 0) {
        int digit = n % 10;
        n = n / 10;
        System.out.print(digit + " ");
        }

    }
}
