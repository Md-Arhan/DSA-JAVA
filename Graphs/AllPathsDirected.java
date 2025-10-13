import java.util.ArrayList;

public class AllPathsDirected {

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

        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    //exponential TC -> O(V^V)
    public static void printAllPaths(ArrayList<Edge> graphs[], int src, int dest, StringBuilder sb){
        if (src == dest) {
            System.out.println(sb.append(dest) + " ");
            return;
        }

        for(int i=0; i<graphs[src].size(); i++){
            Edge e = graphs[src].get(i);
             printAllPaths(graphs, e.dest, dest, new StringBuilder(sb).append(src));
        }
    }

    public static void main(String args[]){
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 5;
        int dest = 1;
        StringBuilder  sb = new StringBuilder();
        /*
         * How StringBuilder Works in Recursion
           Key Concept:
           Each recursive call creates a new StringBuilder instance, so each path is built separately without interference from other paths.
         */
        printAllPaths(graph, src, dest, sb);
        
    }
}





/*
 * 2️⃣ During recursion:

Every call stack has its own StringBuilder reference.

Even though objects live on heap, the reference to that object lives in the current function's local stack frame.

3️⃣ When the recursive call returns (i.e. "coming back"):

The stack frame of that recursive call is destroyed.

Its local variables (like that copy of StringBuilder) become unreachable.

If no other references point to that StringBuilder, Java's Garbage Collector will clean it up automatically later.
 */




/* Time Complexity :
 * 
You explore all possible paths, not just the shortest.
For every node, you're recursively visiting all its neighbors.
If there are cycles → you might visit infinite paths.
But you don't have cycle detection here, so you assume it's a DAG (Directed Acyclic Graph), otherwise your program can go into infinite recursion.

The number of paths can be exponential.
In worst case, number of paths = O(2^V) (or more generally, exponential in V)
→ because at each node, you may have multiple choices (neighbors) to go to.

 Space Complexity:
Call stack depth: O(V) (since you may traverse down to all nodes)
Each recursive call creates a new StringBuilder:
Worst case: O(V) space per path string
Total space:
O(V) (for call stack) +
O(V) (for each StringBuilder created in recursion)
*/



/*Call Stack Depth = O(V)
At any given moment during recursion:

You are inside a path.

A path cannot contain more than V nodes (if you don't allow revisiting the same node inside a path).

But since you do allow revisiting (because no visited array), technically the same node can appear multiple times, which means the path can theoretically be longer than V.

👉 So strictly speaking, without cycle detection,
maximum call stack depth can be unbounded (could even go infinite if cycles exist). */