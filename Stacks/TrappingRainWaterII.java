package Stacks;

import java.util.PriorityQueue;

public class TrappingRainWaterII {
    class Solution {
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length, m = heightMap[0].length;
        if (n <= 2 || m <= 2) return 0;

        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, m - 1, heightMap[i][m - 1]});
            visited[i][0] = true;
            visited[i][m - 1] = true;
        }
        for (int j = 1; j < m - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{n - 1, j, heightMap[n - 1][j]});
            visited[0][j] = true;
            visited[n - 1][j] = true;
        }

        int trapped = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int r = cell[0], c = cell[1], h = cell[2];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;
                visited[nr][nc] = true;

                trapped += Math.max(0, h - heightMap[nr][nc]);

                pq.offer(new int[]{nr, nc, Math.max(heightMap[nr][nc], h)});
            }
        }
        return trapped;
    }
}
}


/*
 * Think of water spreading from the boundary:
You only let water flow into unvisited interio cells.
Once a cell is visited, it acts as a new “wall” for its neighbors.
No need to reprocess it because it already contributes to trapped water correctly.
 */

 /*
  * Imagine you’re filling water from the outside inward
Pop the lowest wall from PQ (always lowest first).
Look at the neighbor:
If it’s lower → water fills in, record trapped water.
If it’s higher → it’s a new wall.
Push neighbor into PQ with its true wall height or filled water level.
Over time, the PQ ensures water expands naturally just like in real life.
  */

/*
 * Imagine the grid is a container of blocks:
You start pouring water from the edges inward.
You never need to check a block twice — once water level is determined there, it’s either full or blocked.
visited is like a marker that says “this block has already been considered”.
 */