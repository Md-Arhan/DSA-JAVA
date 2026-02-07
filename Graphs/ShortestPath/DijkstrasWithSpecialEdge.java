package ShortestPath;

public class DijkstrasWithSpecialEdge {
    import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int v;      // vertex
        int d;      // distance
        boolean used; // whether special cost already used

        Pair(int v, int d, boolean used){
            this.v = v;
            this.d = d;
            this.used = used;
        }

        @Override
        public int compareTo(Pair other){
            return Integer.compare(this.d, other.d);
        }
    }

    public int shortestPath(int V, int a, int b, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            int cwt = edge[3];

            adj.get(u).add(new int[]{v, wt, cwt});
            adj.get(v).add(new int[]{u, wt, cwt});
        }

        final int INF = Integer.MAX_VALUE / 4;
        int[][] dist = new int[V][2];
        boolean[][] vis = new boolean[V][2];

        for (int i = 0; i < V; i++) {
            dist[i][0] = INF;
            dist[i][1] = INF;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[a][0] = 0;
        pq.add(new Pair(a, 0, false));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int vtx = curr.v;
            int curD = curr.d;
            int usedIdx = curr.used ? 1 : 0;

            // If this state has already a better distance, skip
            if (vis[vtx][usedIdx]) continue;
            vis[vtx][usedIdx] = true;

            // relax neighbors
            for (int i = 0; i < adj.get(vtx).size(); i++) {
                int[] neigh = adj.get(vtx).get(i);
                int to = neigh[0];
                int wt = neigh[1];
                int cwt = neigh[2];

                // Normal weight, used stays the same
                if (curD + wt < dist[to][usedIdx]) {
                    dist[to][usedIdx] = curD + wt;
                    pq.add(new Pair(to, dist[to][usedIdx], curr.used));
                }

                // If special not used yet, we can use cwt and flip used -> true
                if (!curr.used) {
                    if (curD + cwt < dist[to][1]) {
                        dist[to][1] = curD + cwt;
                        pq.add(new Pair(to, dist[to][1], true));
                    }
                }
            }
        }

        int ans = Math.min(dist[b][0], dist[b][1]);
        return ans >= INF ? -1 : ans;
    }
}

}
