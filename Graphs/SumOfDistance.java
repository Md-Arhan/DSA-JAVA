import java.util.ArrayList;

public class SumOfDistance {
    class Solution {
    int N;
    ArrayList<ArrayList<Integer>> graph;
    int ans[];
    int count[];

    public void dfs(int curr, int par) {
        count[curr] = 1;
        for (int i = 0; i < graph.get(curr).size(); i++) {
            int neigh = graph.get(curr).get(i);
            if (neigh!=par) {
                dfs(neigh, curr);
                count[curr]+=count[neigh];
                ans[0]+=count[neigh];
            }
        }

    }

    public void dfs2(int curr, int par){
        for (int i = 0; i < graph.get(curr).size(); i++) {
            int neigh = graph.get(curr).get(i);
            if (neigh!=par) {
                ans[neigh] = ans[curr] - count[neigh] + (N - count[neigh]);
                dfs2(neigh, curr);
            }
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        graph = new ArrayList<>();
        count = new int[n];
        ans = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        dfs(0, -1);
        dfs2(0, -1);

        return ans;
    }
}


/*
 * 🔴 Why your naive solution was slow

For each node i, you ran a full DFS to calculate all distances.

That’s O(n) per node → total O(n²).

Works for small n, but fails for n up to 
3
×
10
4
3×10
4
.

We need to avoid recalculating everything again for each node.

✅ Optimized Approach: Tree DP with Rerooting

The trick is:

Pick one root (say node 0).

Compute the sum of distances from this root to all nodes.

Also compute the subtree sizes (how many nodes each subtree has).

Move the root to each child ("rerooting").

Use the parent’s answer to calculate the child’s answer in O(1).

Formula:
ans[child]=ans[parent]−count[child]+(n−count[child])

🤔 Why does the formula work?

Imagine we have parent → child.

When we move the root down from parent to child:

Nodes in the child’s subtree (count[child] of them) become 1 step closer.

All other nodes (n - count[child]) become 1 step farther.

ans[child]=ans[parent]−count[child]+(n−count[child])
 */