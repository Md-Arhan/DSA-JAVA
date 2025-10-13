package TopologicalSort;

public class Islands {
    
}


// Approach

/*
  Approach (with Steps)
🔶 Step 1: Remove Border-Connected Lands
  Why?
  Any land (0) that is connected to the grid border cannot be "closed".
  So we do a DFS or BFS flood-fill to convert all such 0s into 1s (i.e., mark them visited or "not valid").

**Why do we need to remove border-connected land (0s) first?
🔍 Because a closed island must be completely surrounded by water (1s).
If a group of land (0s) touches any edge of the grid, then:
It's not fully surrounded.
Therefore, it cannot be a closed island.
🔄 So, what's the risk if we don't remove them?
If we don't remove border-connected 0s, your algorithm might incorrectly count them as closed islands, because:
They are connected internally like an island,
But they are not surrounded on all four sides — one side is touching the grid edge.

If you don’t flood/remove land (0s) connected to the edges, then:
➡️ Those edge-connected lands might look like valid islands inside the grid
➡️ But they're not surrounded by 1s on all four sides, since they touch the border
➡️ So they get wrongly counted as closed islands


🔶 Step 2: Count Closed Islands
After Step 1, all open islands touching the border are removed.

Now, every remaining 0 is a closed island, so we:

Loop through every cell

When we find a 0, we do a DFS and increase the island count
*/