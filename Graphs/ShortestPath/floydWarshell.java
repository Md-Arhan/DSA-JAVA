package ShortestPath;

public class flyodShell {
    class Solution {
    final static int INF = 99999; // A large number representing "infinity"
    final static int V = 4;       // Number of vertices in the graph

    void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];

        // Step 1: Initialize the solution matrix same as input graph matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Step 2: Update dist[][] considering all vertices as intermediate
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Step 3: Print the final shortest distance matrix
        printSolution(dist);
    }

    void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = {
            { 0, 5, INF, 10 },
            { INF, 0, 3, INF },
            { INF, INF, 0, 1 },
            { INF, INF, INF, 0 }
        };

        Solution a = new Solution();
        a.floydWarshall(graph);
    }
}
}



/*
 * Each loop runs 𝑛 times.
The innermost operation is a constant time comparison and assignment.
So overall complexity is 𝑛×𝑛×𝑛=𝑂(𝑛3)n×n×n=O(n3)

Extra Notes:
Space complexity: 𝑂(𝑛2) for the dist matrix.
 */


/*
 * If:

dist[i][j] is the current known shortest path from i to j
dist[i][k] is the shortest path from i to k
dist[k][j] is the shortest path from k to j

 What does dist[i][k] + dist[k][j] mean?
It means:so it is telling go to [i][k] means if we are at 2 go to 1 and check there is there any possibilty to go for 3 from there

"If I'm at node i, can I go to node j via an intermediate node k, and is that route shorter than what I already know?"
Or simplified
"From i, go to k, then from k, go to j. If this is shorter than my current path from i to j, update it."
 */