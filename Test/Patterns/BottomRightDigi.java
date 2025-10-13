package Test.Patterns;

public class BottomRightDigi {

    public static void topLeft() {
        int n = 5;

        for (int i = 1; i <= n; i++) {
            // int num = 1;
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int n = 5;

        // for (int i = 1; i <= n; i++) {
        //     int num = 1;
        //     for (int j = 1; j <= n; j++) {
        //         if (i + j <= n + 1) {
        //             System.out.print(num);
        //         } else {
        //             System.out.print(" ");
        //         }
        //         num++;
        //     }
        //     System.out.println();
        // }
        topLeft();

    }
}
