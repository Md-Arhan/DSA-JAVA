package Arrays.Array_2D;

public class SpiralMatrix {
    public static void spiralMarix(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][endCol] + " ");
            }

            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int mat[][] = {
                { 1, 2, 3, 4, 5, 6, 7, 8 },
                { 9, 10, 11, 12, 13, 14, 15, 16 }
        };
        spiralMarix(mat);
    }
}

/*
 * Why Don't the Other Loops Run?
 * Let's check each loop:
 * 
 * 1️⃣ Right Column (Top to Bottom)
 * 
 * java
 * Copy
 * Edit
 * for (int i = startRow + 1; i <= endRow; i++) {
 * System.out.print(matrix[i][endCol] + " ");
 * }
 * ✅ Condition Check: startRow + 1 = 3, but endRow = 1
 * 🔴 3 ≤ 1 is false, so the loop does not run.
 * 
 * 2️⃣ Bottom Row (Right to Left)
 * 
 * java
 * Copy
 * Edit
 * for (int j = endCol - 1; j >= startCol; j--) {
 * if (startRow == endRow) break;
 * System.out.print(matrix[endRow][j] + " ");
 * }
 * ✅ Condition Check: startRow = 2, endRow = 1
 * 🔴 startRow == endRow is false, but endRow < startRow, so the loop does not
 * run.
 * 
 * 3️⃣ Left Column (Bottom to Top)
 * 
 * java
 * Copy
 * Edit
 * for (int i = endRow - 1; i > startRow; i--) {
 * if (startCol == endCol) break;
 * System.out.print(matrix[i][startCol] + " ");
 * }
 * ✅ Condition Check: endRow - 1 = 0, startRow = 2
 * 🔴 0 > 2 is false, so the loop does not run.
 */

/*
 * 🔹 Second Iteration
 * 1️⃣ Top Row Traversal (→)
 * Prints: 5 6
 * Update: startRow = 2
 * 2️⃣ Right Column Traversal (↓)
 * Prints: 9
 * Update: endCol = 0
 * 3️⃣ Bottom Row Traversal (←) ⬅️ Condition Hits Here
 * Now, startRow == endRow (2 == 2)
 * Condition triggers: if (startRow == endRow) break;
 * Breaks out of Bottom Row Traversal
 * o Why is 8 Still Printed?
 * Because it was printed in the next step (left column traversal)! Let’s
 * continue.
 * Checking if (startCol == endCol) break;
 * startCol == endCol (1 == 1), so the condition is FALSE.
 * Loop runs for i = 1 (index of 8).
 * Prints 8
 * 
 * Prevents duplicate printing of row 2
 * Final Output:
 * Copy
 * Edit
 * 1 2 3 6 9 12 11 10 7 4 5 6 9 8
 */