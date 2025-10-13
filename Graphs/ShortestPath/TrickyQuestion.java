package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrickyQuestion {
    
class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        // Collect all important points (nodes)
        List<int[]> pts = new ArrayList<>();
        pts.add(new int[]{start[0], start[1]}); // index 0
        pts.add(new int[]{target[0], target[1]}); // index 1

        for (int[] r : specialRoads) {
            pts.add(new int[]{r[0], r[1]}); // road start
            pts.add(new int[]{r[2], r[3]}); // road end
        }

        // Map each point to an index
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < pts.size(); i++) {
            String key = pts.get(i)[0] + "," + pts.get(i)[1];
            idx.put(key, i);
        }

        int n = pts.size();
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        // Add normal move edges (Manhattan) between all points
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int cost = manhattan(pts.get(i), pts.get(j));
                adj[i].add(new int[]{j, cost});
            }
        }

        // Add special roads as directed edges
        for (int[] r : specialRoads) {
            int u = idx.get(r[0] + "," + r[1]);
            int v = idx.get(r[2] + "," + r[3]);
            adj[u].add(new int[]{v, r[4]});
        }

        // Dijkstra
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{0,0}); // {node, cost}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (d > dist[u]) continue;
            if (u == 1) return d; // reached target

            for (int[] e : adj[u]) {
                int v = e[0], w = e[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return -1;
    }

    private int manhattan(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
}


/*Example
Queue content (node, cost):

(3, 10), (3, 5)
We pop (3, 10).

dist[3] is 5 (cheaper).

10 > 5, so we continue (skip).

Then later, we pop (3, 5) and process it.

Key Difference:
BFS (unweighted graph):
The first time you reach a node is always the shortest path.
So you can mark visited[node] = true and never revisit.
Dijkstra (weighted graph):
The first time you reach a node might not be the shortest if you find a cheaper path later.
So you keep track of the best cost so far (dist[]), not just a visited flag.
 */