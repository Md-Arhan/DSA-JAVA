package ShortestPath;
import java.util.*;

public class CheapestFlights {

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge>[] graph) {
        /*
         * This is how how data stores in adjacency list form
         * graph[0] -> [(0 → 1, 100)]
         * graph[1] -> [(1 → 2, 100), (1 → 3, 600)]
         * graph[2] -> [(2 → 0, 100), (2 → 3, 200)]
         * graph[3] -> []
         */
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            System.out.println(src);
            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int dis[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dis[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src; 
                int v = e.dest;
                int wt = e.wt;

                if (dis[u] != Integer.MAX_VALUE && curr.cost + wt < dis[v] && curr.stops <= k) { // if we are for neighbour to find the dest if stops k dont perform
                    dis[v] = curr.cost + wt;
                    q.add(new Info(v, dis[v], curr.stops + 1));
                }
            }
        }

        // dis[dest]
        if (dis[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dis[dest];
        }

    }

    public static void main(String args[]) {
        int n = 4;
        int fligths[][] = {
                { 0, 1, 100 },
                { 1, 2, 100 },
                { 2, 0, 100 },
                { 1, 3, 600 },
                { 2, 3, 200 }
        };
        int src = 0, dest = 3, k = 1;
        int res = cheapestFlight(n, fligths, src, dest, k);
        System.out.println(res);
    }
}





/*
 * 
 * Problem with comparing only dist[v]:
Suppose:
You reached v earlier with higher cost and fewer stops.
Later you might reach v again with lower cost but more stops (still within k limit).
So, in this problem, we allow multiple visits to the same node with different (cost, count) combinations.
 */


 /*
  * ✅ Why you are comparing with curr.cost + wt instead of always relying on dist[v]?
Because your queue can still give you paths out of order.
BFS explores level-by-level, not cost-by-cost.
So it's very possible that:
You reached a node early with high cost.
Later, another path reaches same node with fewer total cost, but more stops.

✅ In Dijkstra:
Since you're always picking minimum cost first (due to priority queue),
you don't need to revisit or check later — your first visit is always optimal.
  */


/*
 * In simple words:
You are always evaluating your current path:

You ask:
"From where I am right now (curr), if I go to the next neighbor (v), will this new cost (curr.cost + wt) be better than what I have previously stored for v?"
You're not thinking globally like Dijkstra (which always picks global min-cost next node).
Instead, you're doing local decisions for each path you explore.
 */


/*
 * unlike checking the updated vertex cost for from another path
 */