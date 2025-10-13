import java.util.ArrayList;

public class CycleDetection {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 3));

        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 2));

        // // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 1));

        // graph[3].add(new Edge(3, 0));
        // graph[3].add(new Edge(3, 4));

        // graph[4].add(new Edge(4, 3));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

    }

    //O(V+E)
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if (!vis[i]) {
                if(detectCycleUtil(graph, vis, i, -1)){
                    return true;
                    //cycle exists in of the parts
                }
            }
        }

        return false;
    }

    /*
     * Step-by-step execution
       Start at 0, mark vis[0] = true.
       Explore 0 → 1
       vis[1] = true, recurse into 1.
       Explore 1 → 0
       vis[0] is already visited.
       Short-circuiting skips the cycle check (wrong behavior).
       Moves to 1 → 2.
       Explore 2 → 1
       vis[1] is already visited.
       Again, short-circuiting skips cycle check.
       DFS finishes but misses cycle detection.
       🔴 Incorrect Output: "No Cycle detected" (wrong behavior)
     */

     /*
      * Step-by-step execution
        Start at 0, mark vis[0] = true.
        Explore 0 → 1
        vis[1] = true, recurse into 1.
        Explore 1 → 0
        0 is the parent → Ignore (correct behavior).
        Explore 1 → 2
        vis[2] = true, recurse into 2.
        Explore 2 → 0
        0 is NOT the parent → Cycle detected!
        Returns true all the way back.
        ✅ Correct Output: "Cycle detected" (expected behavior).        
      */

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par){
         vis[curr] = true;

         for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            //case 3
            if (!vis[e.dest]) {
                if ( detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }

            }

            //case 1
            else if(vis[e.dest] && e.dest != par){
                return true;
            }
            //Case 2 -> do noting -> continue
         }

         return false;
    }
    
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }
}
