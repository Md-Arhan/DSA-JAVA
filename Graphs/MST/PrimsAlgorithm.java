package MST;

import java.util.ArrayList;
import java.util.PriorityQueue;

import MST.PrimsAlgorithm.Pair;

public class PrimsAlgorithm {   //O((V+E)logV)
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

    static void createGraph(ArrayList<Edge> graph[]){

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

         //0 -> vertex 
         graph[0].add(new Edge(0, 1, 10));
         graph[0].add(new Edge(0, 2, 15));
         graph[0].add(new Edge(0, 3, 30));

         //1 -> vertex
         graph[1].add(new Edge(1, 0, 10));
         graph[1].add(new Edge(1, 3, 40));

         //2 -> vertex
         graph[2].add(new Edge(2, 0, 10));
         graph[2].add(new Edge(2, 3, 50));

         //3 -> vertex
         graph[3].add(new Edge(3, 1, 40));
         graph[3].add(new Edge(3, 2, 50));
    }

    static class  Pair implements Comparable<Pair>{
    
        int v;
        int cost;

        public Pair(int v, int c){
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2){
           return this.cost - p2.cost;  // ascending order Sort
        }
    }

    public static void prims(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost+=curr.cost;
                ans.add(curr.v);

                for(int i=0; i<graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();

        System.out.println("minium spanning cost " + finalCost);
    }
    
    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        prims(graph);
    }
}



/*
 * Minimum Spannig Tree is a connected and undirected Graph is a subset if the edges that connected to all vertices,
 * Has no cycle and Minimize the total edges of weight(sum of weights is the smallest possible).
 * 
 * Prim’s Algorithm
Start with any vertex.
Repeatedly add the smallest weight edge that connects a vertex inside the tree to one outside.
 */