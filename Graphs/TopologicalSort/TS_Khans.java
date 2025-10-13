package TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TS_Khans {

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

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void calcIndegree(ArrayList<Edge> graph[], int indeg[]){
        for(int i=0; i<graph.length; i++){
            int v = i;
            for(int j=0; j<graph[v].size(); j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        calcIndegree(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indeg.length; i++){
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        //bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");  //topological sort print

            for(int j=0; j<graph[curr].size(); j++){
                Edge e = graph[curr].get(j);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
            int V = 6;
            @SuppressWarnings("unchecked")
            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
            topSort(graph);

        
    }
}


/*
 * Why BFS is More Complex
🔹 1. ❗ No Recursion Stack in BFS
BFS uses a queue, not recursion.

There’s no built-in "memory" of the path you're currently on.

So BFS can't detect back edges easily in directed graphs — it just sees nodes level by level.

In DFS, you can easily say:
“I’ve seen this node and I’m still processing it → cycle!”
But in BFS, once you dequeue a node, it’s considered processed.

🔹 2. You Need Extra Structures to Simulate Path Tracking
To detect cycles in directed BFS, you would need:

A visited[] array

An in-degree array or custom path-tracking logic

Often you simulate Kahn’s Algorithm (topological sort) to detect cycles

So the logic becomes:

Track in-degrees

Keep removing nodes with in-degree 0

If not all nodes are processed, a cycle exists

📌 This is not intuitive like DFS.

🔹 3. BFS is OK for Undirected Graphs (but Still Needs Parent Tracking)
Even in undirected graphs:

BFS needs to track parent nodes to avoid false cycle detection.

Why?
Because you’ll revisit the parent node during traversal, and you need to ignore that case.

if (visited[neighbor] && neighbor != parent[node]) {
    // Found a cycle
}
Again, extra logic is required.
 */




 /*
 | Reason                                | DFS           | BFS                                       |
| ------------------------------------- | ------------- | ----------------------------------------- |
| Recursion stack / path tracking       | ✅ Built-in    | ❌ Must simulate                           |
| Back edge detection (directed graphs) | ✅ Easy        | ❌ Hard                                    |
| Parent tracking (undirected graphs)   | ⚠️ Not needed | ✅ Must track manually                     |
| Intuitive cycle detection             | ✅ Yes         | ❌ No (needs tricks like Kahn’s Algorithm) |
 
*/








/*
 * Steps of kahan's Algorithm : 

 Fact : A DAG has at least one indegree u as 0 or least one degree v is 0, if not cycle exist

 * Steps of Kahn's Algorithm:
Calculate indegree of all vertices.

Push all vertices with indegree 0 into a queue.

While the queue is not empty:

Remove a node u from the queue and add it to the result.

For all neighbors v of u, decrease v's indegree by 1.

If v's indegree becomes 0, add it to the queue.

If all nodes are processed, return the topological order.

If not, the graph contains a cycle, so topological sort is not possible.


 */







/*| Feature                             | **Kahn’s Algorithm**         | **DFS-based Approach**              |
| ----------------------------------- | ---------------------------- | ----------------------------------- |
| **Cycle Detection**                 | Easy via `inDegree` check    | Needs explicit `recStack[]`         |
| **Ordering**                        | Builds order level-by-level  | Builds order via reverse post-order |
| **Code Complexity**                 | Simple with queue            | Needs recursion or explicit stack   |
| **Memory Usage**                    | Slightly more for `inDegree` | Uses call stack or extra arrays     |
| **Supports multiple valid orders?** | Yes                          | Yes                                 |
| **Avoids Recursion Limit**          | ✅ Yes                        | ❌ Risk in large graphs              |
 */