package Arrays.Array_2D;

public class Transpose {
    public static int[][] transpose(int arr[][]) {

        int r = arr.length;
        int c = arr[0].length;

        int arr1[][] = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr1[j][i] = arr[i][j];
            }
        }

        // for (int i = 0; i < arr1.length; i++) {
        //     for (int j = 0; j < arr1[0].length; j++) {
        //         System.out.print(arr1[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return arr1;
    }

    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] = {
                { 11, 12, 13 },
                { 21, 22, 23 }
        };

        int transpose[][] = transpose(arr);
        print(transpose);
    }
}
