package Arrays.Array_2D;
import java.util.*;;

public class Basics {
    public static boolean search(int numbers[][]) {
        int key = 6;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                if (numbers[i][j] == key) {
                    System.out.println("found " + i + "," + j);
                    return true;
                }
            }
        }
        System.out.println("Not found");
        return false;
    }

    public static void main(String[] args) {
        int martix[][] = new int[3][3];
        int n = martix.length, m = martix[0].length;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                martix[i][j] = sc.nextInt();
            }
        }
        sc.close();

        // output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(martix[i][j] + " ");
            }
            System.out.println();
        }

        search(martix);

    }
}
