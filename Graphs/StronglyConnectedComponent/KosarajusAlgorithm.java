package StronglyConnectedComponent;
import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgorithm {

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

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }

    public static void topSort(ArrayList<Edge> graph[], int curr,  boolean[] vis, Stack<Integer> s){
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }

        s.add(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[], ArrayList<Integer> res){
        vis[curr] = true;
        System.out.print(curr + " ");
        res.add(curr);

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis, res);
            }
        }
    }

    public static void kosaRaju(ArrayList<Edge> graph[], int V){
        //Step1
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[V];

        for(int i=0; i<graph.length; i++){
            if (vis[i] == false) {
                topSort(graph, i, vis, s);
            }
        }

        //Transpose graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge> tranpose[] = new ArrayList[V];
        for(int i=0; i<graph.length; i++){
            vis[i] = false;
            tranpose[i] = new ArrayList<>();
        }

        for(int i=0; i<V; i++){
           for(int j=0; j<graph[i].size(); j++){
            Edge e = graph[i].get(j); //e.src -> e.dest
            tranpose[e.dest].add(new Edge(e.dest, e.src));  //reverse
           }
        }

        ArrayList<Integer> res = new ArrayList<>();

        //step3
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                System.out.print("SCC -> ");
                dfs(tranpose, curr, vis, res);
                System.out.println();
            }
        }

        int ans = res.get(0);
        System.out.println(ans);

    }
    
    public static void main(String []args){
        int V = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosaRaju(graph, V);
    }
}



/*
 *Why just reversing and DFS doesn’t work:
In a directed graph, connections between nodes are not necessarily symmetrical. So when you reverse the edges, the structure changes, and:
❗ You can’t tell which nodes in the reversed graph form a complete SCC just by DFS unless you start from the right nodes in the right order.

Let's walk through it step-by-step:
➤ Step 1: Do DFS on the original graph
This helps us get the finish time order of nodes.

We store this in a stack — the last finished node is on top.

Why this helps:

The node that finishes last in the original DFS is likely a source in the condensed graph (DAG of SCCs).

So when we reverse the graph, that node becomes a sink, and we can fully explore one SCC from it.

➤ Step 2: Reverse the graph
All edges are flipped.

➤ Step 3: Pop nodes from the stack, do DFS on reversed graph
The first node we pop will be part of one SCC (because it’s a sink in the reversed graph).

DFS from that node will visit all members of that SCC.

We mark them as visited and move on to the next unvisited node.

Each DFS in this phase gives us one full SCC.
 */