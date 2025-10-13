package Disjoint_Set_DS;

import java.util.Arrays;

public class ConnectingPoints {
    public int minCostConnectPoints(int[][] points) {
    int n = points.length;
    boolean[] visited = new boolean[n];
    int[] minDist = new int[n];
    Arrays.fill(minDist, Integer.MAX_VALUE);
    minDist[0] = 0;  // Start from node 0

    int totalCost = 0;

    for (int i = 0; i < n; i++) {
        int u = -1;
        int min = Integer.MAX_VALUE;
        
        // Find the unvisited node with the smallest distance
        for (int v = 0; v < n; v++) {
            if (!visited[v] && minDist[v] < min) {
                min = minDist[v];
                u = v;
            }
        }

        visited[u] = true;
        totalCost += min;

        // Update distances for remaining nodes
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                if (dist < minDist[v]) {
                    minDist[v] = dist;
                }
            }
        }
    }

    return totalCost;
}

}
