package FloodFill;

public class MinimumNumberOfDisconneced {
    public void Util(int[][] copy, int row, int col) {
        if (row >= copy.length || row < 0 || col < 0 || col >= copy[0].length || copy[row][col] == 0) {
            return;
        }

        copy[row][col] = 0;

        Util(copy, row - 1, col);
        Util(copy, row + 1, col);
        Util(copy, row, col - 1);
        Util(copy, row, col + 1);

    }

    public int isDisIsland(int[][] grid) {
        int count = 0;

        int copy[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                copy[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                if (copy[i][j] == 1) {
                    Util(copy, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public int minDays(int[][] grid) {
        if (isDisIsland(grid) != 1) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (isDisIsland(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
}
