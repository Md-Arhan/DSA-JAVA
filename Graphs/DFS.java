import java.util.ArrayList;

public class DFS {

    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

         //0 -> vertex
         graph[0].add(new Edge(0, 1, 1));
         graph[0].add(new Edge(0, 2, 1));

         //1 -> vertex
         graph[1].add(new Edge(1, 0, 1));
         graph[1].add(new Edge(1, 3, 1));

         //2 -> vertex
         graph[2].add(new Edge(2, 0, 1));
         graph[2].add(new Edge(2, 4, 1));

         //3 -> vertex
         graph[3].add(new Edge(3, 1, 1));
         graph[3].add(new Edge(3, 4, 1));
         graph[3].add(new Edge(3, 5, 1));

         //4 -> vertex
         graph[4].add(new Edge(4, 2, 1));
         graph[4].add(new Edge(4, 3, 1));
         graph[4].add(new Edge(4, 5, 1));

         //5 -> vertex
         graph[5].add(new Edge(5, 3, 1));
         graph[5].add(new Edge(5, 4, 1));
         graph[5].add(new Edge(5, 6, 1));

         //6 -> vertex
         graph[6].add(new Edge(6, 5, 1));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visited[]){
        //O(V+E)
        //visit
        System.out.println(curr + "");
        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dfs(graph, 0, new boolean[V]);
    }
}


/*
 * Yes — in principle, most dynamic data structures require manual initialization for nested (inner) elements.
But no — they are not entirely the same, because how they store, link, and access data internally is still different.

🔍 Let's compare:
🔸 ArrayList<List<Integer>>:
You create the outer list → new ArrayList<>()

Then you must add each inner list manually → list.add(new ArrayList<>())

🔸 LinkedList<LinkedList<Integer>>:
Same rule: create outer linked list → new LinkedList<>()

Then add each inner linked list manually → linkedList.add(new LinkedList<>())

🔸 HashMap<Integer, List<Integer>> (e.g., for adjacency list):
Same: create outer map → new HashMap<>()

Then create and assign inner list → map.put(key, new ArrayList<>())

🧠 Why this happens?
Because:

Java collections like ArrayList, LinkedList, HashMap store references to objects.

If you don’t create and assign the inner object, the reference is null, and using it causes a NullPointerException.

//Initialization: 

List<List<Integer>> list = new ArrayList<>();
You're only creating the outer list, which will hold references (pointers) to inner lists.

At this point:

The inner lists don’t exist yet.

The outer list is just an empty list of null references (or more precisely, it's empty — it doesn’t have anything at all until you .add() to it).

“Even after creating the inner list, does it actually exist inside the outer list, or is it still just a pointer (reference)?”
✅ Answer:
It is still just a reference (pointer) — even after you create and add the inner list.
Java collections (like ArrayList, LinkedList, etc.) always store references to objects, not the objects themselves.
 */