package Arrays.Array_2D;

public class StairCase {
    public static boolean stepcase(int mat[][], int target) {

        int row = 0, col = mat[0].length - 1;

        while (row < mat.length && col >= 0) {
            if (mat[row][col] == target) {
                return true;
            } else if (mat[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static boolean searchSort(int martix[][], int target) {
        int row = martix.length - 1, col = 0;

        while (col < martix[0].length && row >= 0) {
            if (martix[row][col] == target) {
                return true;
            } else if (target < martix[row][col]) {
                row--; // Move up target is smaller
            } else {
                col++; // move right target is larger
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8, 9 }
        };
        int target = 7;
        System.out.println(stepcase(mat, 15));
        System.out.println(searchSort(mat, target));

    }
}
