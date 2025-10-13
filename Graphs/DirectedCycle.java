import java.util.ArrayList;

public class DirectedCycle {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

   static void createGraph(ArrayList<Edge> graph[]){

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

         //0 -> vertex
         graph[0].add(new Edge(0, 2));


         //1 -> vertex
         graph[1].add(new Edge(1, 0));

         //2 -> vertex
         graph[2].add(new Edge(2, 3));

         //3 -> vertex
         graph[3].add(new Edge(3, 0));

    }

    public static boolean isCycle(ArrayList<Edge> graph[]){  //O(V+E), This function use to scroll down on every components in graphs
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[] ){   //Actual work
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }
    
    public static void main(String []args){
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);   
        System.out.println(isCycle(graph)); 
    }
}


/*
 * Why use DFS and not BFS for cycle detection in graphs?
The short answer is:
✅ DFS is better suited for detecting cycles because it naturally explores paths deeply and keeps track of the current path using recursion or a stack — which helps detect back edges (a sign of a cycle).



Cycle Detection Using DFS
🔹 In a Directed Graph:
DFS helps us detect back edges — edges pointing to an ancestor in the current recursion path.

We use:

A visited set (or array) to mark nodes we've seen
A recursionStack (or call stack) to track the current path
If we reach a node that's in the recursion stack → cycle exists.

🔹 In an Undirected Graph:
DFS visits nodes and keeps track of the parent node.
If a visited neighbor is not the parent, it means a cycle is found.





Why Not BFS?
BFS can be used for cycle detection in undirected graphs, but:

It needs extra logic to track parent nodes.

It’s harder in directed graphs because it doesn’t keep a natural recursive call stack (no "path memory").

In directed graphs, BFS cannot track the current path, so detecting back edges (which cause cycles) is tricky.


 */






// Important

/*
 * Why DFS is More Efficient for Cycle Detection
🔹 DFS (Depth-First Search):
DFS goes deep into the graph before backtracking.

It naturally maintains the current path using the call stack (or an explicit stack).

This helps in detecting back edges easily, which are a clear sign of a cycle (especially in directed graphs).

You can detect cycles as soon as you find a node that's already in the current path.

👉 This makes DFS:

✅ Efficient in cycle detection

✅ Simple to implement

✅ Faster to stop when a cycle is found

🔹 BFS (Breadth-First Search):
BFS explores the graph level by level, removing one element at a time from a queue.

It doesn’t maintain the full current path in memory.

So in directed graphs, it can’t detect back edges directly.

You have to use extra logic, like in-degree tracking (Kahn’s Algorithm), to detect cycles.

👉 This makes BFS:

❌ Less natural for cycle detection

❌ More complex in directed graphs

⚠️ Still usable for undirected graphs (with parent tracking)



Summary (Exam Line):
✅ DFS is more efficient and intuitive for cycle detection, especially in directed graphs, because it explores deep paths and tracks the current path using a call stack — making back edge detection simple.
❌ BFS, in contrast, explores one node at a time and requires extra logic, making it more complex for cycle detection.
 */