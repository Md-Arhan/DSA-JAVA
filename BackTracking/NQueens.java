package BackTracking;

public class NQueens {
    public static boolean isSafe(char board[][], int row, int col) {

        // vertical side
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void prinyBoard(char board[][]) {
        System.out.println("---------Chess Board---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void nQueens(char board[][], int row) {

        if (row == board.length) {
            prinyBoard(board);
            count++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1); // funtion call
                board[row][j] = 'x'; // Backtracking Step
            }
        }
    }

    public static boolean nQueensOneSolution(char board[][], int row) {

        if (row == board.length) {
            count++;
            return true;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (nQueensOneSolution(board, row + 1)) {
                    return true;
                }
                board[row][j] = 'x';
            }
        }
        return false;
    }

    static int count = 0;

    public static void main(String[] args) {
        int n = 5;
        char board[][] = new char[n][n];
        // initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        // Print Ones Solution
        // if (nQueensOneSolution(board, 0)) {
        // System.out.println("Solution is possible");
        // prinyBoard(board);
        // } else {
        // System.out.println("Not Possible");
        // }

        nQueens(board, 0);
        System.out.println();
        System.out.println("Total Ways = " + count);
    }
}