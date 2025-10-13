import java.util.ArrayList;
import java.util.Arrays;

public class BFSCycle {
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

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], int curr,  int V, int[] par, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        vis[curr] = true;
        q.add(curr);

        while (!q.isEmpty()) {
            int u = q.poll();

            for(int i=0; i<graph[u].size(); i++){
                Edge e = graph[u].get(i);
                if (!vis[e.dest]) {
                    vis[e.dest] = true;
                    q.add(e.dest);
                    par[e.dest] = u;
                }else if(par[u] != e.dest){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycle(ArrayList<Edge> graph[], int V){
        boolean[] vis = new boolean[V];
        int[] par = new int[V];
        Arrays.fill(par, -1);

        for(int i=0; i<V; i++){
            if (!vis[i]) {
               if(detectCycleUtil(graph, i, V, par, vis)){
                return true;
               }
            }
        }
        return false;
    }

    
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph, V));
    }
}
