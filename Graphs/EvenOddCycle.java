import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class EvenOddCycle {

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
    
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0)); // Forms cycle 0 → 1 → 2 → 0 (odd-length 3)
    
        // graph[1].add(new Edge(3, 0));
        // graph[3].add(new Edge(3, 4));
        // graph[4].add(new Edge(4, 1)); // Forms cycle 1 → 3 → 4 → 1 (odd-length 3)
    }
    

    public static int detectCycleLength(ArrayList<Edge>[] graph) {
        int[] col = new int[graph.length];
        Arrays.fill(col, -1); // -1 means uncolored
        int[] level = new int[graph.length]; // To track depth from source

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { // Start BFS for unvisited nodes
                q.add(i);
                col[i] = 0; // Start coloring
                level[i] = 0; // Root node at level 0

                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (Edge e : graph[curr]) {
                        if (col[e.dest] == -1) { 
                            col[e.dest] = 1 - col[curr]; // Alternate coloring
                            level[e.dest] = level[curr] + 1; // Increase depth
                            q.add(e.dest);
                        } else if (col[e.dest] != col[curr]) { 
                            // Cycle found; return its length
                            return (level[curr] - level[e.dest] + 1);
                        }else{
                            return (level[curr] - level[e.dest] + 1);
                        }
                    }
                }
            }
        }

        return -1; // No cycle found
    }

    public static void main(String args[]) {
        // if graph doesn't have cycle -> BIPARTITE

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int cycleLength = detectCycleLength(graph);

        if (cycleLength == -1) {
            System.out.println("No Cycles");
        } else if (cycleLength % 2 == 0) {
            System.out.println("Even Cycle Found, Length: " + cycleLength);
        } else {
            System.out.println("Odd Cycle Found, Length: " + cycleLength);
        }
    }
}

/*
 * 
 * Understanding the Formula Step by Step
   level[curr]: The depth (distance from the start node) of the current node.
   level[e.dest]: The depth of the neighbor node where a back edge is detected.
   level[curr] - level[e.dest]: This gives the number of edges between curr and e.dest in the BFS tree.
   +1: Since a cycle includes both the start and end nodes, we add 1 to include the back edge
 */


/*

      0
     / \
    1   2
    |   |
    3 - 4

    1. Maintain a level array (level[i]) that tracks how far each node is from the starting node.

    2. When a cycle is detected, use the difference in levels to determine if it's odd or even.

 */