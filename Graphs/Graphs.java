import java.util.*;

public class Graphs {

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void main(String[] args) {
        /*
         *                   (5)
         *             0-------1
         *                   /   \
         *               (1)/     \(3)
         *                 /       \ 
         *                2---------3
         *                |    (1)
         *                |
         *             (2)|
         *                4
         */

         int V = 5;
         @SuppressWarnings("unchecked")
         ArrayList<Edge>[] graph = new ArrayList[V];  //null(undefined) -> empty arrayList

         for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
         }

         //0 -> vertex
         graph[0].add(new Edge(0, 1, 5));

         //1 -> vertex
         graph[1].add(new Edge(1, 0, 5));
         graph[1].add(new Edge(1, 2, 1));
         graph[1].add(new Edge(1, 3, 3));

         //2 -> vertex
         graph[2].add(new Edge(2, 1, 1));
         graph[2].add(new Edge(2, 3, 1));
         graph[2].add(new Edge(2, 4, 2));

         //3 -> vertex
         graph[3].add(new Edge(3, 1, 3));
         graph[3].add(new Edge(3, 2, 1));

         //4 -> vertex
         graph[4].add(new Edge(4, 2, 2));

         //2's neighbour
         for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);     //src, dest, wt
            System.out.println(e.dest + "," + e.wt);
         }

        //Example Visualization of ArrayList Storage: 
        /*0	Edge(0, 1, 5)
        1 -	Edge(1, 0, 5), Edge(1, 2, 1), Edge(1, 3, 3)
        2 -	Edge(2, 1, 1), Edge(2, 3, 1), Edge(2, 4, 2)
        3 -	Edge(3, 1, 3), Edge(3, 2, 1)
        4 -	Edge(4, 2, 2) 
        */
    }
}



/*We use a visited data structure (like an array or set) in graph algorithms to keep track of which nodes have already been explored. This is critical for correctness, efficiency, and avoiding infinite loops.

* Reasons to Use visited:
1. Avoid Revisiting Nodes
Prevents redundant work.

Ensures each node is only processed once.

2. Avoid Infinite Loops
In graphs with cycles, especially undirected or cyclic directed graphs, not marking nodes as visited can lead to infinite traversal.

3. Track Path or State
Useful in algorithms like DFS or BFS where you explore nodes level-by-level or depth-by-depth.

Can help in cycle detection, pathfinding, or component counting.
 */