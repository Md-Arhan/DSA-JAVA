package Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SafeStates {
    public boolean dfs(int curr, ArrayList<ArrayList<Integer>> graphs, boolean isCycle[], boolean vis[]) {
        isCycle[curr] = true;
        vis[curr] = true;

        for (int i = 0; i < graphs.get(curr).size(); i++) {
            int neigh = graphs.get(curr).get(i);

            if (isCycle[neigh]) {
                return true;
            }

            if (!vis[neigh]) {
                if (dfs(neigh, graphs, isCycle, vis)) {
                    return true;
                }
            } 
            
        }

        isCycle[curr] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> graphs = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            graphs.add(new ArrayList<>());

            for (int v : graph[i]) {
                graphs.get(i).add(v);
            }
        }

        boolean isCycle[] = new boolean[graph.length];
        List<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graphs.size(); i++) {
            if (!dfs(i, graphs, isCycle, vis)) {
                ans.add(i);
            }
        }

        Collections.sort(ans);

        return ans;

    }
}



/*
 * Step 3. Loop through all nodes
i = 0 → dfs(0)

mark isCycle[0] = true, vis[0] = true

neighbors of 0 → [1,2]

neigh = 1

isCycle[1] = false, vis[1] = false → recurse dfs(1)

dfs(1):

mark isCycle[1] = true, vis[1] = true

neighbors of 1 → [2,3]

a. neigh = 2

isCycle[2] = false, vis[2] = false → recurse dfs(2)

dfs(2):

mark isCycle[2] = true, vis[2] = true

neighbors of 2 → [5]

i. neigh = 5

isCycle[5] = false, vis[5] = false → recurse dfs(5)

dfs(5):

mark isCycle[5] = true, vis[5] = true

neighbors of 5 → [] (no neighbors)

set isCycle[5] = false, return false (safe node)

back to dfs(2): neighbor 5 returned false → continue

finish loop, set isCycle[2] = false, return false (safe)

b. neigh = 3

isCycle[3] = false, vis[3] = false → recurse dfs(3)

dfs(3):

mark isCycle[3] = true, vis[3] = true

neighbors of 3 → [0]

neigh = 0

but isCycle[0] = true → cycle detected → return true

so dfs(3) returns true

back to dfs(1) → since dfs(3) returned true, dfs(1) returns true

back to dfs(0) → since neighbor 1 gave cycle, dfs(0) returns true

So node 0 is unsafe, not added to ans.

i = 1

Already visited (vis[1] = true).

dfs(1) returns true (cycle).

Not safe.

i = 2

Already visited, dfs(2) returned false earlier → safe.

So ans = [2].

i = 3

Already visited, dfs(3) returned true → unsafe.

i = 4

Not visited yet → dfs(4)

mark isCycle[4] = true, vis[4] = true

neighbors of 4 → [5]

neigh = 5 → dfs(5) already done, returned false (safe)

finish, set isCycle[4] = false, return false → safe

ans = [2,4]

i = 5

Already visited, dfs(5) returned false → safe

ans = [2,4,5]

i = 6

Not visited → dfs(6)

mark isCycle[6] = true, vis[6] = true

neighbors of 6 → []

set isCycle[6] = false, return false → safe

ans = [2,4,5,6]

🔹 Step 4. Sort ans

ans = [2,4,5,6] (already sorted).
 */