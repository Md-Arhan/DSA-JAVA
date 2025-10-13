package ShortestPath;
import java.util.ArrayList;
import java.util.PriorityQueue;

import ShortestPath.Dijkstras.Pair;

public class Dijkstras {  //O((V+E)logV)

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path; // path based sorting my pairs
        }
    }

    public static void dijkstras(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if (i != src) {
                dist[i] = Integer.MAX_VALUE; // +infinity
            }
        } 

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        //loop
        while(!pq.isEmpty()){
           Pair curr = pq.remove();
           if (!vis[curr.n]) {
              vis[curr.n] = true;
              for(int i=0; i<graph[curr.n].size(); i++){
                Edge e = graph[curr.n].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[u]+wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
              }
           }
        }

        //print all soyrce to vertices shortest to dist;
        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i] + " ");
        } 
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        dijkstras(graph, src);
    }
}



/*

When you update a node's distance, you add it to the queue.
If later you find a better path, you add it again.
The PriorityQueue may have many copies of the same node (with old distances).

Even after you process a node once (and you think you’re "done" with it), later you might discover a better path to that node from some other vertex.
This is why — if you're not using visited[] — you might insert the same node again into the PriorityQueue.

✅ Dijkstra’s Algorithm:
Works on:
Cyclic graphs
Acyclic (DAG) graphs
Directed and undirected graphs
Graphs with non-negative edge weights
❌ Does not work with:
Negative edge weights → because it assumes once a node is visited with the shortest path, it doesn't need to be updated again — which fails when negative weights exist.
 */




 /*
  *  If you directly use edge list for algorithms like DFS, BFS, Dijkstra:
Every time you visit a node and want to process its neighbors:

You have to loop over all edges and check:
So for every recursive call (DFS, Dijkstra, etc.), you end up scanning the full edge list.

This makes your neighbor lookup O(E) for each node.
  */






/*
 💡 Dijkstra's Algorithm — The Rule
At every step, always pick the unvisited node with the smallest known distance from the start node.
Then, update its neighbors' distances if you found a shorter path to them.

🔬 Formal steps of Dijkstra:
1️⃣ Start:

Set the distance of start node = 0.
Set the distance of all other nodes = ∞ (infinity).
2️⃣ Put all nodes into an unvisited set.

3️⃣ While unvisited nodes remain:

Select the unvisited node with the smallest known distance.

Mark it as visited.

For each neighbor of that node:
If going through this node gives a shorter distance to the neighbor → update it.
4️⃣ Repeat until all nodes are visited (or until you reached your target).

🚩 The core idea:
Always explore the most promising node first (smallest distance so far).

🔥 Key concept:
Dijkstra always assumes:

"If I already visited a node with the smallest possible distance, I don't need to revisit it again."
This is only true if you always process the smallest distance node first.
That’s why you need a priority queue (or something similar) to guarantee this.

⚠ If you don't follow that rule:
Dijkstra's assumption breaks.

You may lock in a wrong distance too early.

You get wrong answers.
 */



/*
 *  What Dijkstra's Algorithm Is Designed For:
Dijkstra’s algorithm is specifically designed to avoid updating visited nodes.

🔁 It works like this:
Start from the source node.
Use a priority queue (min-heap) to always pick the unvisited node with the smallest distance.
Once you pop a node from the queue and mark it as visited:
You are guaranteeing: "This is the shortest path to this node."
You never need to update this node again, because no future path will be shorter.


Dijkstra’s Flow (Simplified)
Start with a source node. Set its distance to 0, all others to ∞.

Push the source into a min-priority queue (PQ), sorted by shortest distance.
While the queue is not empty:
Pop the node with the smallest current distance → cur
If curr is already visited, skip (to avoid unnecessary work)
Mark curr as visited
Loop over all neighbors of curr:
For each neighbor next:
If dist[curr] + edgeWeight < dist[next]:
Update dist[next]
Push next into the queue with updated distance
 */