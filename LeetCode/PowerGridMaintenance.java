import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PowerGridMaintenance {
    

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= c; i++) adj.add(new ArrayList<>());
        for (int[] e : connections) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 2: Find connected components
        int[] comp = new int[c + 1];
        int compId = 0;
        for (int i = 1; i <= c; i++) {
            if (comp[i] == 0) {
                compId++;
                dfs(i, compId, adj, comp);
            }
        }

        // Step 3: Create TreeSet for each component
        Map<Integer, TreeSet<Integer>> compSets = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int id = comp[i];
            compSets.computeIfAbsent(id, k -> new TreeSet<>()).add(i);
        }

        // Step 4: Process queries
        boolean[] isOnline = new boolean[c + 1];
        Arrays.fill(isOnline, true);
        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0], x = q[1];
            int id = comp[x];

            if (type == 1) {
                if (isOnline[x]) {
                    ans.add(x);
                } else {
                    TreeSet<Integer> set = compSets.get(id);
                    if (set != null && !set.isEmpty()) ans.add(set.first());
                    else ans.add(-1);
                }
            } else { // type == 2
                if (isOnline[x]) {
                    isOnline[x] = false;
                    TreeSet<Integer> set = compSets.get(id);
                    if (set != null) set.remove(x);
                }
            }
        }

        // Step 5: Convert list to array
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }

    private void dfs(int node, int id, List<List<Integer>> adj, int[] comp) {
        comp[node] = id;
        for (int nei : adj.get(node)) {
            if (comp[nei] == 0) dfs(nei, id, adj, comp);
        }
    }
}

}
