mimport java.util.ArrayList;

public class MinimumHeightTree {
    class Solution {

        public void calcIndegree(int[][] edges, int indegree[], ArrayList<ArrayList<Integer>> adj) {
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                adj.get(u).add(v);
                adj.get(v).add(u);

                indegree[u]++;
                indegree[v]++;
            }
        }

        public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
            // Code here
            int indegree[] = new int[V];
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            calcIndegree(edges, indegree, adj);

            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 1) {
                    q.add(i);
                }
            }

            int remaining = V;

            while (V > 2) {
                int size = q.size();
                V -= size;

                for (int i = 0; i < size; i++) {
                    int curr = q.remove();
                    for (int j = 0; j < adj.get(curr).size(); j++) {
                        int neig = adj.get(curr).get(j);

                        indegree[neig]--;

                        if (indegree[neig] == 1) {
                            q.add(neig);
                        }
                    }
                }
            }

            ArrayList<Integer> ans = new ArrayList<>();

            while (!q.isEmpty()) {
                ans.add(q.poll());
            }

            return ans;
        }
    }
}
/*

Here’s the intuition behind what your code did with that tree:
- The algorithm treats the tree like an onion: you peel off the outer leaves layer by layer.
- Leaves are nodes with degree = 1. Removing them reduces the degree of their neighbors, and some neighbors then become new leaves.
- You keep repeating this process until only the core of the tree remains.
In your example:
- First layer of leaves: nodes 3, 4, 5.
- Removing them exposes nodes 0 and 2 as new leaves.
- Removing those exposes node 1 as the final remaining node.
That last node is the centroid — the most balanced root. Rooting the tree at this node minimizes the maximum distance to all other nodes, so the tree’s height is as small as possible.
👉 Intuition: Minimum Height Trees are found by trimming leaves until you reach the center. The center (1 or 2 nodes) is the optimal root.
Would you like me to show how the height looks if you root the tree at node 1 versus rooting it at, say, node 0, so you can see why node 1 is better?
*/