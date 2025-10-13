package TarjansAlgorithm;

import java.util.ArrayList;

public class Bridge_in_Graph {

    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int[] dt, int[] low, boolean[] vis, int time) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (Edge e : graph[curr]) {
            int neigh = e.dest;

            if (neigh == par) {
                continue;
            }

            if (!vis[neigh]) {
                dfs(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);

                // Bridge condition
                if (dt[curr] < low[neigh]) {
                    System.out.println("Bridge: " + curr + "----" + neigh);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]); // Back edge
            }
        }
    }

    public static void tarjansBridge(ArrayList<Edge>[] graph, int V) {
        int[] dt = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        int time =  0 ; // Mutable time reference

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        tarjansBridge(graph, V);
    }
}




/*
 Step-by-Step Execution
1st DFS Call: dfs(0, -1)
Node 0:
Mark vis[0] = true
Set dt[0] = low[0] = 0
Explore neighbors 1, 2, 3
DFS on 1 (dfs(1, 0))
Node 1:
Mark vis[1] = true
Set dt[1] = low[1] = 1
Explore 0, 2
Skip 0 (parent)
Go to 2
DFS on 2 (dfs(2, 1))
Node 2:

Mark vis[2] = true
Set dt[2] = low[2] = 2
Explore 0, 1
Skip 1 (parent)
0 is already visited → Back Edge (2 → 0)
Update low[2] = min(low[2], dt[0]) = min(2, 0) = 0
Backtrack to Node 1

Update low[1] = min(low[1], low[2]) = min(1, 0) = 0
Backtrack to Node 0

Update low[0] = min(low[0], low[1]) = min(0, 0) = 0
DFS on 3 (dfs(3, 0))
Node 3:
Mark vis[3] = true
Set dt[3] = low[3] = 3
Explore 0, 4
Skip 0 (parent)
Go to 4
DFS on 4 (dfs(4, 3))
Node 4:

Mark vis[4] = true
Set dt[4] = low[4] = 4
Explore 3
Skip 3 (parent)
Backtrack to Node 3

Update low[3] = min(low[3], low[4]) = min(3, 4) = 3
Backtrack to Node 0

Update low[0] = min(low[0], low[3]) = min(0, 3) = 0
Finding Bridges
Bridges exist where dt[u] < low[v].
Comparing:

Edge	dt[u]	low[v]	Bridge?
(0,1)	0	0	❌ No
(0,2)	0	0	❌ No
(1,2)	1	0	❌ No
(0,3)	0	3	✅ Yes
(3,4)	3	4	✅ Yes
Output
arduino
Copy
Edit
Bridge: 0----3
Bridge: 3----4
 */



/*
 * Quick Recap of Terms:
dt[curr]: Discovery time of the current node.
low[curr]: The earliest discovered node reachable from the current node or its subtree.
vis[neigh]: Whether the neighbor has been visited.
The else block is where we detect a back edge (edge to an ancestor, not the parent).



🔍 Why we use dt[neigh] in the else block:
✅ In the else block:
You’re not going deeper (DFS won’t go into neigh because it's already visited).
This means neigh is an ancestor, and the edge (curr, neigh) is a back edge.
So to update low[curr], we need the discovery time of the ancestor node (neigh), i.e., dt[neigh].
🔑 Using low[neigh] here would be wrong, because low[neigh] includes information from neigh's descendants, which we don't want to consider in the back edge case — only its discovery time.



🔄 Comparison:
✅ low[curr] = Math.min(low[curr], dt[neigh]);
Correct for back edges
Helps bubble up the earliest ancestor reachable
❌ low[curr] = Math.min(low[curr], low[neigh]);
Would incorrectly consider descendants of neigh
Could lead to missing a bridge
 */



// Main

/*updating the low[curr] with dist if we update with low[niegh] it gives the ancestor low discovery time not the neigbors discovery time 
 * Because when we encounter a back edge to a visited node (neigh), it must be an ancestor of the current node (curr) in the DFS tree.
And we care about how early that ancestor (neigh) was discovered, not how early its descendants could reach in their own subtree (which is stored in low[neigh]).

🔁 In the back edge case, neigh is an already visited ancestor of curr,
so we should update low[curr] with dt[neigh], not low[neigh],
because low[neigh] includes descendant info, which we don't want when tracing back edges.

Why we check dt[curr] < low[neigh] (not dt[neigh]):
During DFS, the discovery time dt[...] always increases as we go deeper.
So dt[curr] < dt[neigh] is always true for a child, and useless for checking bridges.
But low[neigh] tells us:
"What is the earliest node that the entire subtree rooted at neigh can reach?"



When you're doing:

ldt[curr] = Math.min(ldt[curr], ldt[neighbor]);
You're asking:

"Can the subtree rooted at neighbor reach back to me (curr) or any of my ancestors via a back edge?"
If it can, then that connection is part of a cycle — and the edge curr — neighbor is not a bridge.
If it can’t, that means:
"The only way for neighbor to stay connected to the rest of the graph is through me (curr)."
That’s exactly what makes this edge a bridge — removing it would disconnect the graph.

"Is there a way for neighbor or its descendants to stay connected without me?"
That’s why ldt[curr] = min(ldt[curr], ldt[neighbor]) is the heart of Tarjan’s algorithm.
*/

