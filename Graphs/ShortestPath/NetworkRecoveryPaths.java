package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NetworkRecoveryPaths {
    // Topological Sort (Kahn's Algorithm)
    public ArrayList<Integer> topologicalSort(int n, List<List<int[]>> graph) {
        int[] indegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);

            for (int[] edge : graph.get(curr)) {
                int v = edge[0];
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }

        return result;
    }

    // Check if a path exists from 0 to n-1 with min edge weight >= m and total cost <= k
    public boolean isPathPossible(ArrayList<Integer> tSort, List<List<int[]>> graph, int minEdgeWeight, int n, long k) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        for (int u : tSort) {
            if (dist[u] == Long.MAX_VALUE) continue;
            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int wt = edge[1];

                if (wt >= minEdgeWeight && dist[u] + wt < dist[v] && dist[u] + wt <= k) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        return dist[n - 1] <= k;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        int left = Integer.MAX_VALUE;
        int right = 0;

        // Build graph only with online nodes and track edge weights for binary search
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            if (!online[u] || !online[v]) continue;

            graph.get(u).add(new int[]{v, wt});
            left = Math.min(left, wt);
            right = Math.max(right, wt);
        }

        ArrayList<Integer> tSort = topologicalSort(n, graph);
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPathPossible(tSort, graph, mid, n, k)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}


/*
 * ✅ Without Priority Queue (like Topo Sort or BFS)
You manually explore all paths in a fixed order (e.g., topological sort in a DAG). You:
Process each node once (in order)
Update neighbors by relaxing edges
Can track all possible ways to reach a node within a given constraint
Great when:
The graph is a DAG
You want all paths considered
There's a guarantee of no cycles

⚠️ Downside:
You might relax edges that aren't optimal early on.
You only get optimal paths if the order is correct (e.g., in DAGs).

✅ With Priority Queue (Dijkstra)
You always expand the cheapest path first, using a min-heap or priority queue.
Nodes are visited based on current shortest cost
Great for finding the optimal path quickly
Early pruning is possible — you might skip bad paths fast
Great when:
You care about the minimum total cost
The graph may have cycles
You want to optimize runtime

 So What’s the Key Difference?
Method	Explores All Paths?	Respects Path Cost?	Order of Node Processing
Topological Sort	✅ Yes	❌ No (unless you design it carefully)	Fixed (based on DAG)
Dijkstra (PQ)	✅ Yes	✅ Yes (best cost first)	Based on min total cost

Priority Queue:
Improves Time Complexity (TC), but
Increases Space Complexity (SC)
 */




/*
 * Let’s Compare Approaches:
1. Without Priority Queue (like Topological Sort + DP)
✅ Time Complexity: O(N + E) (linear for DAGs)

❗ Condition: Only works when the graph is a DAG.

🚫 Can't dynamically choose the next best node, you follow a fixed order.

2. With Priority Queue (like Dijkstra)
✅ Time Complexity: O((N + E) * logN) using a min-heap

✅ Works on cyclic graphs, greedy selection of best cost paths

✅ Can exit early if destination reached

3. Brute Force BFS Without Priority Queue
❌ Inefficient if multiple paths lead to same node with better cost

❌ Might revisit nodes unnecessarily, leading to worse TC than O((N+E) logN)

🚨 Can go up to exponential time if not careful (especially if path cost checks aren't optimized)
 */




/*Goal
We need to maximize the minimum edge weight along a valid path (0 → n-1), while ensuring:
Every edge weight on that path ≥ chosen value (mid)
Total sum of edge weights ≤ k

Approac
Binary Search on minEdgeWeight
Start with left = min(edge weights) and right = max(edge weights).
Each mid is a candidate for the minimum edge weight.
Check Feasibility for mi
Ignore all edges with weight < mid.
Find the shortest total cost path from 0 to n-1 (DAG DP using topological order).
If a valid path exists with total cost ≤ k → possible.
Adjust search range
If possible(mid) is true → try a bigger mid (increase left).
Else → mid too large, reduce right.
 */