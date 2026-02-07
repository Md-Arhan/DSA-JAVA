import java.util.ArrayList;

public class LongestPathGraph {
    public void dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean vis[], int dist[], int node[], int d){
        vis[curr] = true;
        if(d > dist[0]){
            dist[0] = d;
            node[0] = curr;
        }
        
        for(int i=0; i<adj.get(curr).size(); i++){
            int neigh = adj.get(curr).get(i);
            if(!vis[neigh]){
                dfs(neigh, adj, vis, dist, node, d+1);
            }
            
        }
    }
    
    public int diameter(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int dist[] = new int[1];
        int node[] = new int[1];
        boolean vis[] = new boolean[V];
        
        dfs(0, adj, vis, dist, node, 0);
        
        int nextEle= node[0];
        node = new int[1];
        dist = new int[1];
        vis = new boolean[V];
        
        dfs(nextEle, adj, vis, dist, node, 0);
        
        return dist[0];
        
    }
}
