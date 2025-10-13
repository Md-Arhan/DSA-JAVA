package TopologicalSort;
import java.util.ArrayList;
import java.util.Stack;

//TC - O(V+E)

public class TopologicalSort {

     static class Edge {
        int src;
        int dest;


        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph[2].add(new Edge(2, 3));

        // graph[3].add(new Edge(3, 1));

        // graph[4].add(new Edge(4, 0));
        // graph[4].add(new Edge(4, 1));

        // graph[5].add(new Edge(5,0));
        // graph[5].add(new Edge(5,2));
    }

    public static void topSort(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<graph.length; i++){
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);  //modified dfs
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s){
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }

        s.add(curr);
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}




/* How stack works on this problem so, the main thing of topological sort is to  arrange the vertices in linear order,
   and it should be toplogical sorting order, which tells higher preferneces (dependency) vertices will comes first before the v 
   so if verteices has it own neighbour then the parent must be has higher preference so we use to store all the vertex will coming back from recusive fxn
   as soon as the traversal complete the higher prefernces will be on top bcz we add at the last
 */



/* 
Why Backtracking Matters in DFS Cycle Detection
When doing DFS to detect a cycle in a directed graph, you mark nodes that are currently in the recursion stack (i.e., "active" on the current path).

If you revisit a node already on the current DFS path, that's a cycle.

But if you revisit a node that was visited on a previous, finished path, it’s not a cycle.

So after finishing DFS for a node, you must backtrack — remove it from the current path.*/ 



/*
 * Why DFS works for topo sort:
DFS goes deep first — i.e., it visits all descendants (dependencies) before finishing the current node.

Once all descendants are fully processed, we can safely say:

"Now u can be added — all nodes that depend on u have been visited."

So when we push nodes after all their neighbors are visited,
and finally reverse that list (or pop from stack),
we get the correct topological order.

🔑 Intuition:
DFS explores → finishes → adds node → reverse = topological order

📊 Think like real-life example:
Imagine you have tasks:

Task A must be done before task B.

Task B must be done before task C.

When DFS explores C, then B, then A (going deep),
and adds nodes after finishing, you'll get the correct order:

[A, B, C]
👉 In one line:
DFS topological sort is basically "post-order traversal" on a DAG.
We add (or "finish") a node after all of its descendants have been processed.so 
 */


 /*
  * 🔑 Topological Sort intuition:
Goal: Put dependencies first.

For every edge u → v, u must come before v.

🔑 Why DFS works:
DFS goes deep first (backward as you said).

It explores all descendants first (because they depend on current node).

After finishing all descendants, we add the current node.
*/