package Test.Questions;
import java.util.*;

public class Fibonacci {
    // Fibonacci Program

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        int f1 = 0;
        int f2 = 1;
        int f3 = 0;

        for (int i = 0; i <= num; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        System.out.println(f3);

    }

}
