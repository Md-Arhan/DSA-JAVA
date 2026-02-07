public class NearestZero {
    class Solution {
    
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Add all 1's to queue (multi-source BFS)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j, 0}); // row, col, distance
                    visited[i][j] = true;
                }
            }
        }

        // Step 2: Define directions (up, down, left, right)
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Step 3: BFS traversal
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], d = curr[2];
            dist[r][c] = d;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, d + 1});
                }
            }
        }

        // Step 4: Convert int[][] → ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(dist[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }
}

}
