package BackTracking;

public class Sudoku {
    
    public static boolean isSafe(int suduko[][], int row, int col, int digi) {
        // col
        for (int i = 0; i <= 8; i++) {
          if (suduko[i][col] == digi) {
            return false;
          }
        }
    
        // row
        for (int j = 0; j <= 8; j++) {
          if (suduko[row][j] == digi) {
            return false;
          }
        }
    
        // grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
          for (int j = sc; j < sc + 3; j++) {
            if (suduko[i][j] == digi) {
              return false;
            }
          }
        }
        return true;
      }
    
      public static boolean sudokuSolver(int sudoku[][], int i, int j) {
        // base Case
        if (i == 9) {
          return true;
        }
    
        // Recursion
    
        int nextRow = i, nextCol = j + 1;
        if (nextCol == 9) {
          nextRow = i + 1;
          nextCol = 0;
        }
    
        if (sudoku[i][j] != 0) {
          return sudokuSolver(sudoku, nextRow, nextCol);
        }
    
        for (int digi = 1; digi <= 9; digi++) {
          if (isSafe(sudoku, i, j, digi)) {
            sudoku[i][j] = digi;
            if (sudokuSolver(sudoku, nextRow, nextCol)) {
              return true;
            }
            sudoku[i][j] = 0;
          }
        }
        return false;
      }
    
      public static void printSuduko(int board[][]) {
        System.out.println("--------- Suduko ---------");
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            System.out.print(board[i][j] + " ");
          }
          System.out.println();
        }
      }
    
      public static void main(String[] args) {
        // int n = 9;
        int suduko[][] = {
            { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
            { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
            { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
            { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
            { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
            { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
            { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
            { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
            { 8, 2, 7, 0, 0, 9, 0, 1, 3 },
            {}
        };
        if (sudokuSolver(suduko, 0, 0)) {
          System.out.println("Solution exists");
          printSuduko(suduko);
        } else {
          System.out.println("Solution not exists");
        }
      }
}
