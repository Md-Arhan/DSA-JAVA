package FloodFill;

public class DisjointPath {
    class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        if (!dfs(grid, 0, 0)) {
            return true;
        }
        grid[0][0] = 1;
        return !dfs(grid, 0, 0);
    }

    private boolean dfs(int[][] grid, int n, int m) {
        if (n < 0 || m < 0 || n >= grid.length || m >= grid[0].length || grid[n][m] == 0) {
            return false;
        }
        if (grid.length - 1 == n && grid[0].length - 1 == m) {
            return true;
        }
        grid[n][m] = 0;
        return dfs(grid, n + 1, m) || dfs(grid, n, m + 1);
    }
}
}
