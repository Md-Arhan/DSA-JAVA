package Edges;

import java.util.ArrayList;
import java.util.List;

public class Edges {
    public class GraphExample {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void dfs(int node) {
        visited[node] = true;
        System.out.println("Visited: " + node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int n = 3;

        // Build the graph
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // remove if directed
        }

        // Initialize visited array
        visited = new boolean[n];

        // Start DFS from node 0
        dfs(0);
    }
}

}




/*
 * Exactly! The repeated scanning of the entire edges array in every recursive call causes your algorithm to do way more work than necessary, especially for larger graphs. This is why you get Time Limit Exceeded (TLE) errors.
 * Why does it cause TLE?
Suppose you have E edges and V vertices.

Each DFS call loops through all E edges to find neighbors.

In the worst case, this can lead to roughly O(V × E) time complexity.

For large inputs, that’s too slow and exceeds time limits.

| Approach                          | Time complexity      | Why                          |
| --------------------------------- | -------------------- | ---------------------------- |
| Looping over edges every DFS call | O(V × E) (too slow)  | Scans all edges repeatedly   |
| Using adjacency list              | O(V + E) (efficient) | Visits each edge & node once |

 */



/*
 * Exactly! That’s the common and best practice for almost all graph problems where you’re given edges:

Why convert edges to adjacency list?
Faster neighbor lookup: You can directly access neighbors of a node without scanning the entire edges array repeatedly.

Cleaner code: Traversing neighbors is straightforward — no need to check every edge.

Better performance: Reduces time complexity from potentially O(V×E) to O(V+E), which is critical for large graphs.

Easier to implement graph algorithms: DFS, BFS, shortest paths, connected components, etc., are simpler and more efficient on adjacency lists.

So the typical flow is:
Input: edges array int[][] edges

Build: adjacency list, e.g., List<List<Integer>> adj

Traverse: use DFS or BFS on adj

Solve: the problem efficiently!
 */