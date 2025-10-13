package ShortestPath.Bellmon;

public class StrictlyBellmonFord {
    class Edge {
    int src, dest, wt;
    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        wt = w;
    }
}

public class BellmanFordStrict {
    
    public static void bellmanFordStrict(Edge edges[], int V, int src) {
        int[] dist = new int[V];
        
        // Initialize distances
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Do V-1 iterations
        for (int i = 0; i < V - 1; i++) {
            // We create a copy of dist so we don't use fresh updates
            int[] newDist = dist.clone();

            // Relax all edges
            for (Edge e : edges) {
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < newDist[v]) {
                    newDist[v] = dist[u] + wt;
                }
            }
            dist = newDist;
            
            // Debug output for each iteration:
            System.out.print("After iteration " + (i + 1) + ": ");
            for (int d : dist) {
                if (d == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(d + " ");
            }
            System.out.println();
        }

        // Final result:
        System.out.println("Final shortest distances:");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + ": " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        int V = 5; // nodes 0 to 4
        Edge edges[] = {
            new Edge(0, 1, 2), // S → A (2)
            new Edge(1, 2, 3), // A → B (3)
            new Edge(2, 3, 4), // B → C (4)
            new Edge(3, 4, 1)  // C → D (1)
        };
        bellmanFordStrict(edges, V, 0);  // Source: node 0 (S)
    }
}

}




/*
 * | Style                     | How relaxations happen inside each pass?                                     |
| ------------------------- | ---------------------------------------------------------------------------- |
| Pure Bellman-Ford         | All edges processed together in one pass; allows using fresh updates         |
| Strict phased explanation | Explained conceptually that distance updates may "propagate" slowly per pass |


Actual Bellman-Ford (normal version you code in practice)
In iteration 1, you process all edges.
You allow updates within same pass.
That's why B and C also get updated in first iteration.

trict pass version means:

In each iteration, we do not use freshly updated values inside the same iteration.
All relaxations use distances as they were at the start of that iteration.
This mimics very slow propagation.
Technically, this is more like synchronous Bellman-Ford.


 */