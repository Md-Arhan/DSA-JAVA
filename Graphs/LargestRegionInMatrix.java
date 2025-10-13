//Findd the size of the largest region int the boolean Matrix

/*
 * First, it finds region (4 connected 1s) → regionSize = 4
maxRegion = Math.max(0, 4) = 4
Later, it finds another region (1 isolated 1) → regionSize = 1
maxRegion = Math.max(4, 1) = 4 (unchanged)
 */


public class LargestRegionInMatrix {
    static class Edge {
        int r, c;

        Edge(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int largestRegionInMatrix(int m[][]) {
        int maxRegion = 0;
        int rows = m.length, cols = m[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};  // All 8 directions
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};  

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (m[i][j] == 1 && !visited[i][j]) {
                    int regionSize = bfs(m, i, j, visited, dr, dc);
                    maxRegion = Math.max(maxRegion, regionSize);
                }
            }
        }

        return maxRegion;
    }

    private static int bfs(int[][] m, int r, int c, boolean[][] visited, int[] dr, int[] dc) {
        Queue<Edge> q = new LinkedList<>();
        q.add(new Edge(r, c));
        visited[r][c] = true;
        int size = 0;

        while (!q.isEmpty()) {
            Edge curr = q.poll();
            size++;

            for (int i = 0; i < dr.length; i++) {
                int newR = curr.r + dr[i];
                int newC = curr.c + dc[i];

                if (newR >= 0 && newR < m.length && newC >= 0 && newC < m[0].length 
                    && m[newR][newC] == 1 && !visited[newR][newC]) {
                    
                    visited[newR][newC] = true;
                    q.add(new Edge(newR, newC));
                }
            }
        }

        return size;
    }

    public static void main(String[] args) {
        int m[][] = {
            {0, 0, 1, 1, 0},
            {0, 0, 1, 1, 0}, 
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1}
        };

        System.out.println("Largest Region Size: " + largestRegionInMatrix(m));
    }
}







/*
public class LargestRegion {

    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};  // row directions
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};  // column directions

    // Function to check if the cell is valid
    static boolean isSafe(int[][] matrix, boolean[][] visited, int row, int col) {
        return (row >= 0) && (row < matrix.length) &&
               (col >= 0) && (col < matrix[0].length) &&
               (matrix[row][col] == 1 && !visited[row][col]);
    }

    // DFS function to visit all connected 1s
    static int dfs(int[][] matrix, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        int count = 1; // Count current cell

        for (int k = 0; k < 8; k++) {
            int newRow = row + dr[k];
            int newCol = col + dc[k];

            if (isSafe(matrix, visited, newRow, newCol)) {
                count += dfs(matrix, visited, newRow, newCol);
            }
        }
        return count;
    }

    // Main function to find the largest region
    static int findLargestRegion(int[][] matrix) {
        int maxRegion = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int regionSize = dfs(matrix, visited, i, j);
                    maxRegion = Math.max(maxRegion, regionSize);
                }
            }
        }
        return maxRegion;
    }

    public static void main(String[] args) {
        int[][] M = {
            {0, 0, 1, 1, 0},
            {0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1}
        };

        System.out.println("Size of the largest region: " + findLargestRegion(M));
    }
}

 */