package ShortestPath.Bellmon;

import java.util.ArrayList;

public class BellmanFord {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    // Edge[]
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    static void createGraph2(ArrayList<Edge> graph) {

        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src) {

        int dis[] = new int[graph.length];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;

        int V = graph.length;
        // TC -> O(V*E)
        // algo O(V)
        for (int i = 0; i < V - 1; i++) {
            // edges - O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    // u, v, wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // relaxation
                    if (dis[u] != Integer.MAX_VALUE && dis[u] + wt < dis[v]) {
                        dis[v] = dis[u] + wt;
                    }
                }
            }
        }
    }

    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) {

        int dis[] = new int[V];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;

        // TC -> O(V*E)
        // algo O(V)
        for (int i = 0; i < V - 1; i++) {
            // edges - O(E)
            for (int j = 0; j < graph.size(); j++) {
                Edge e = graph.get(j);
                // u, v, wt
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                // relaxation
                if (dis[u] != Integer.MAX_VALUE && dis[u] + wt < dis[v]) {
                    dis[v] = dis[u] + wt;
                }
            }
        }

        for (int i = 0; i < dis.length; i++) {m
            System.out.print(dis[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // new graph
        ArrayList<Edge> graph = new ArrayList<>();
        // createGraph(graph);
        createGraph2(graph);
        int src = 0;
        // bellmanFord(graph, src);
        bellmanFord2(graph, src, V);

    }
}






/*
 * Bellman-Ford guarantees this:

After exactly V-1 iterations, all shortest paths from the source are correctly calculated — even if some paths are very long (up to V-1 edges).

🔥 Key point:
Sometimes you get the correct answer even earlier — maybe after 1 or 2 iterations.
But Bellman-Ford doesn’t know in advance how many edges any shortest path will require.
So to guarantee correctness for all possible graphs, it always performs V-1 full passes.
✅ Bellman-Ford idea in one sentence:
"Keep relaxing all edges V-1 times — if any better path exists, I’ll eventually find it."

 */




/*
 * 🟢 What is Bellman-Ford?
Bellman-Ford is a single-source shortest path algorithm — like Dijkstra — but works even if there are negative weight edges (as long as there's no negative weight cycle).

🟢 Where Bellman-Ford is used?
✅ When you have:
negative edge weights
you want to detect negative weight cycles
graph can be directed or undirected
works on both adjacency list or edge list
🟢 Algorithm Idea
You start from a source node src.

Distance to all nodes: dis[]
Initialize: dis[src] = 0, others = ∞
Then, for V-1 times (V = total vertices):
You go through all edges (u → v with weight wt).
Apply relaxation:
if dis[u] + wt < dis[v]:
    dis[v] = dis[u] + wt
🟢 Why V-1 times?
👉 Because in the worst case, the shortest path might have V-1 edges (like a chain through all vertices).
For example:
S → A → B → C → D

Shortest path from S to D is 4 edges (V-1 = 5-1 = 4)
Each iteration may only relax one level deeper, so you need V-1 iterations to ensure every possible chain is updated fully.

🟢 After V-1 iterations?
Do one extra pass:

If any edge can still relax, then → Negative Weight Cycle exists.

for each edge (u, v, wt):
    if dis[u] + wt < dis[v]:
        -> negative cycle exists
🟢 Time Complexity
O(V × E)
 */


 

/*
 * 🔑 Core formula:
Bellman-Ford needs V-1 iterations because any shortest path in a graph with V nodes can have at most V-1 edges.

🔥 Why?
In a simple path, you cannot visit more than V-1 edges, otherwise you revisit some node (cycle).
So any shortest path has at most V-1 edges.
Therefore, you need to relax all edges up to V-1 times to ensure even the farthest node from the source gets updated correctly.
 */



 /*
  *  Because you don’t process nodes in order (like Dijkstra), you need multiple full edge passes to "propagate" shortest distances outward step-by-step.

  | Algorithm        | Needs Sorted Priority? | Reason                                                                        |
| ---------------- | ---------------------- | ----------------------------------------------------------------------------- |
| **Dijkstra**     | YES                    | Uses priority queue — always processes smallest distance node first (greedy). |
| **Bellman-Ford** | NO                     | Simply brute-force relaxes all edges again and again.                         |

  */








//Perfect example

/*
 *  You said:
why it's again and again
because we don’t know which u has v and which v has u

Exactly. That’s 100% the point.

We don't know in advance:
Which edge should come first
Which node is depending on which
Which v can only be relaxed after its parent u was relaxed

🔧 Let’s visualize:
Imagine edges randomly ordered like:

From	To	Weight
B	C	4
A	B	3
S	A	2

Even though logically S → A → B → C

The edges might be checked in any random order.

🔄 Why we need multiple full passes:
Iteration	What happens
1	You might relax S → A (A gets distance 2)
1	Then you might check B → C, but B still ∞ → can't update C
1	Then you check A → B → now B gets updated (to 5)
1	But too late for B → C in this pass
2	Now B has valid distance, so you relax B → C
3	If needed, more passes keep checking

🔑 In short:
We don’t know the right processing sequence of nodes upfront
→ so we keep looping all edges again and again
→ until every possible update has "propagated" properly.
 */


/*
 * ✅ Advantages of Adjacency List:
Less memory (better for sparse graphs)

Slightly faster inner loop: you don’t need to scan all nodes to find edges — neighbors are directly available.

✅ Bellman-Ford still needs V-1 passes even if we use adjacency list because:
The issue is not "how" you access edges

The issue is: "how far" updates can travel through the graph (max V-1 edges away from source).
 */