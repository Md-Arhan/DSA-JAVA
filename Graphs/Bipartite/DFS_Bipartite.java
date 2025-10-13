package Bipartite;

import java.util.Arrays;

public class DFS_Bipartite {

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0 = uncolored, 1 = color1, -1 = color2
        Arrays.fill(color, 0); // Initially, all nodes are uncolored

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) { // If the node is unvisited, perform DFS
                if (!dfs(graph, color, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int[] color, int node, int currentColor) {
        color[node] = currentColor; // Color the node

        for (int neighbor : graph[node]) {
            if (color[neighbor] == 0) { // If unvisited, color it with opposite color
                if (!dfs(graph, color, neighbor, -currentColor)) {
                    return false;
                }
            } else if (color[neighbor] == color[node]) { // If same color as current node, not bipartite
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };

        System.out.println(isBipartite(graph) ? "Graph is Bipartite" : "Graph is NOT Bipartite");
    }
}


/*
| Aspect           | **DFS**                            | **BFS**                                   |
| ---------------- | ---------------------------------- | ----------------------------------------- |
| Path traversal   | Goes deep before backtracking      | Goes level-by-level                       |
| Coloring logic   | Uses recursion to alternate colors | Uses a queue to alternate colors          |
| Stack usage      | Uses call stack or custom stack    | Uses queue (easier for level-based color) |
| Code simplicity  | Slightly more complex (recursive)  | Cleaner and more intuitive                |
| Efficiency       | **Same time complexity**: O(V + E) | **Same time complexity**: O(V + E)        |
| Preferred method | ✅ Works well                       | ✅✅ More common and preferred              |
 
*/

/*
Why BFS is Preferred for Bipartite Check:
BFS naturally explores the graph level by level, and this fits 2-coloring really well.
You start from a node, color it with 0, then all neighbors with 1, their neighbors with 0, and so on.
If you ever find two connected nodes with the same color, it's not bipartite. 
*/


/*
  So Why is BFS Preferred?
1. ✅ Level-by-Level Coloring (Natural in BFS)
Bipartite graphs are often described as "level-wise 2-colorable".

BFS visits nodes level by level, so:

Level 0 → color 0

Level 1 → color 1

Level 2 → color 0 again
→ This makes coloring cleaner and more intuitive in BFS.

2. ⚠️ DFS May Cause Stack Overflow (on large graphs)
DFS is recursive → risk of stack overflow on large graphs with deep recursion.

BFS uses an explicit queue → more memory-safe.

3. ✅ BFS Handles Disconnected Graphs Easily
In BFS, you typically start BFS from every unvisited node.

While possible with DFS too, BFS makes it more structured in practice.
 */


/*| Feature                          | DFS                              | BFS (Preferred)                      |
| -------------------------------- | -------------------------------- | ------------------------------------ |
| Works for bipartite check        | ✅ Yes                            | ✅ Yes                                |
| Handles large/deep graphs        | ⚠️ Risk of stack overflow        | ✅ Safer with queue                   |
| Coloring logic                   | ⚠️ Manual color switching        | ✅ Naturally fits level-wise coloring |
| Handles disconnected graphs      | ⚠️ With care                     | ✅ More structured                    |
| Code readability & interview use | ⚠️ Slightly trickier (recursion) | ✅ Cleaner & more intuitive           |

DFS can be used to check if a graph is bipartite, but BFS is preferred because it naturally fits level-wise 2-coloring, avoids recursion depth issues, and is cleaner to implement — especially for large or disconnected graphs.
 */ 