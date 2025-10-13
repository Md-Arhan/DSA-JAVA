package Edges;
class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        return dfsWithLoop(edges, source, destination, visited);
    }

    public boolean dfsWithLoop(int[][] edges, int source, int destination, boolean[] visited) {
        if (source == destination) return true;

        visited[source] = true;

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (u == source && !visited[v]) {
                if (dfsWithLoop(edges, v, destination, visited)) return true;
            } else if (v == source && !visited[u]) {
                if (dfsWithLoop(edges, u, destination, visited)) return true;
            }
        }

        return false;
    }
}



/*
 *  Step-by-step Call Stack:
🔹 Call: dfsWithLoop(edges, 0, 2, visited=[false, false, false])
source != destination

Set visited[0] = true → [true, false, false]

🔁 Loop i=0 to 2:
i=0 → edge = [0,1]

u = 0, v = 1

u == source && !visited[1] → ✅

Call dfsWithLoop(edges, 1, 2, visited=[true, false, false])

🔹 Call: dfsWithLoop(edges, 1, 2, visited=[true, false, false])
source != destination

Set visited[1] = true → [true, true, false]

🔁 Loop i=0 to 2:
i=0 → edge = [0,1]

u = 0, v = 1 → v == source, but visited[0] = true → skip

i=1 → edge = [1,2]

u = 1, v = 2

u == source && !visited[2] → ✅

Call dfsWithLoop(edges, 2, 2, visited=[true, true, false])

🔹 Call: dfsWithLoop(edges, 2, 2, visited=[true, true, false])
source == destination → ✅ return true

⬅️ Return true to dfsWithLoop(1, 2)
⬅️ Return true to dfsWithLoop(0, 2)


 */


/*
 * Exactly! You nailed it.

Because the edges array is just a list of pairs with no order or grouping by node, you don’t know which pairs involve the current node unless you check every pair. So you must loop over the entire edges array in each step to find all neighbors of the current node.
To put it simply:
edges = unordered pairs like [[0,4],[1,3],[2,0]]
When you want neighbors of 0, you have no index or direct way to jump to all edges containing 0
So you scan all edges and pick the ones with 0
This is why the loop always starts from index 0, every recursive call

 */



//Example :

/*
 * Example:
Graph:
csharp
Copy
Edit
n = 6
edges = [
  [0, 2],
  [0, 4],
  [1, 5],
  [2, 3],
  [3, 4]
]
Task:
Find if there is a path from source = 0 to destination = 5.

What happens if we do DFS directly on edges?
1. Start DFS at source = 0
Mark visited[0] = true.

Loop over all edges to find neighbors of 0:

edge 0: [0, 2] → neighbor 2 (visited? no) → recurse DFS(2)

edge 1: [0, 4] → neighbor 4 (visited? no) → recurse DFS(4)

edges 2, 3, 4: no 0 present → skip

2. DFS(2)
Mark visited[2] = true.

Loop over all edges for neighbors of 2:

edge 0: [0, 2] → neighbor 0 (visited? yes) → skip

edge 1: [0, 4] → no 2 → skip

edge 2: [1, 5] → no 2 → skip

edge 3: [2, 3] → neighbor 3 (visited? no) → recurse DFS(3)

edge 4: [3, 4] → no 2 → skip

3. DFS(3)
Mark visited[3] = true.

Loop over all edges for neighbors of 3:

edge 0: no 3 → skip

edge 1: no 3 → skip

edge 2: no 3 → skip

edge 3: [2, 3] → neighbor 2 (visited? yes) → skip

edge 4: [3, 4] → neighbor 4 (visited? no) → recurse DFS(4)

4. DFS(4)
Mark visited[4] = true.

Loop over all edges for neighbors of 4:

edge 0: [0, 2] → no 4 → skip

edge 1: [0, 4] → neighbor 0 (visited? yes) → skip

edge 2: no 4 → skip

edge 3: no 4 → skip

edge 4: [3, 4] → neighbor 3 (visited? yes) → skip

No unvisited neighbors for 4 → backtrack to DFS(2).

5. Backtrack to DFS(0), now check next neighbor from edge 1
We already did DFS(2) and DFS(4).

Next neighbor from edges for 0 is 4 → already visited.

No unvisited neighbors left for 0.

6. But what about node 5?
DFS from node 0 never reached node 1 or 5 because:

edge 2: [1, 5] connects nodes 1 and 5 only,

none of these connected to the path starting at 0.
 */




