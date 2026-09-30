package TarjansAlgorithm;
import java.util.*;

public class ArticulationPoint {
    
    static class Edge{
        int src;
        int dest;
    
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    //O(V+E)
    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], int time, boolean[] vis, boolean[] ap){
       vis[curr] = true;
       dt[curr] = low[curr] = ++time;
       int children = 0;

       for(int i=0; i<graph[curr].size(); i++){
          Edge e = graph[curr].get(i);
          int neigh = e.dest;

          if (par == neigh) {
            continue;
          }else if (vis[neigh]) {
            low[curr] = Math.min(low[curr], dt[neigh]);      // if we tale low[neigh] then in cyclic manner it will give u the wrong answer, 
          }else{
            dfs(graph, neigh, curr, dt, low, time, vis, ap);
            low[curr] = Math.min(low[curr], low[neigh]);    // to detect the cycle

            if (par!=-1 && dt[curr] <= low[neigh]) {
                ap[curr] = true;
                System.out.println("AP : " + curr);
            }
            children++;
          }
       }

       if (children>1 && par == -1) {
        ap[curr] = true;
        System.out.println("AP : " + curr);
       }
    }

    public static void getAP(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean[] vis = new boolean[V];
        boolean ap[] = new boolean[V];

        for(int i=0; i<V; i++){
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, time, vis, ap);
            }
        }

        for(int i=0; i<V; i++){
            if (ap[i]) {
                System.out.println("AP : " + i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getAP(graph, V);
    }
}



/*

The subtle difference
- Back edge case:
When you see a neighbor that’s already visited (and not the parent), that edge is a back edge.
A back edge connects the current node (or its descendants) to an ancestor in the DFS tree.
- Why use dist[neigh]:
dist[neigh] is the discovery time of that ancestor. That’s the earliest point in the DFS when it was first reached.
If you mistakenly use low[neigh], you’re allowing the neighbor’s subtree to influence the calculation — but in a back edge, you don’t care about the neighbor’s descendants, only the ancestor itself.



Why not low[neigh]?
If you used:
low[curr] = Math.min(low[curr], low[neigh]);


then you’d be saying:
"I can reach as early as whatever neigh’s subtree can reach."
But that’s wrong for a back edge, because neigh is already visited and not part of your subtree — you should only consider its discovery time, not its descendants.

*/