// import java.util.*;

public class ConnectedComponents {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Component 1
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 0, 1));

        // Component 2
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 1));

        graph[5].add(new Edge(5, 3, 1));
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfsUtil(graph, i, visited);
                System.out.println();
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, int start,  boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();

        // src = 0
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) { // visit curr
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) { 
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfsUtil(graph, i, visited);
                System.out.println();
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean visited[]) {
        // O(V+E)
        // visit
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfsUtil(graph, e.dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dfs(graph);
        bfs(graph);
    }
}
