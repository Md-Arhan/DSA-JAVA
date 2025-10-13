package Test.Questions;
import java.util.*;

public class SumofDigits {
    public static int compute(int n) {
        int SumofDigit = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            SumofDigit = SumofDigit + lastDigit;
            n = n / 10;
        }
        return SumofDigit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");
        int n = sc.nextInt();
        sc.close();

        System.out.println("The sum is " + compute(n));

    }
}
