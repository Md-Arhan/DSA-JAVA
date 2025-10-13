import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

public class VerticalOrderTraversal {
    List<List<Integer>> ans = new ArrayList<>();
    Map<Integer, List<int[]>> map = new TreeMap<>();

    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public void vertical(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(new int[] { row, node.val });

            if (node.left != null) {
                q.add(new Pair(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, row + 1, col + 1));
            }
        }

        for (List<int[]> colList : map.values()) {
            Collections.sort(colList, (a, b) -> {
                if (a[0] == b[0])
                    return a[1] - b[1]; //sort by value
                return a[0] - b[0]; //sort by row
            });

            List<Integer> setColumn = new ArrayList<>();
            for (int[] col : colList) {
                setColumn.add(col[1]);
            }

            ans.add(setColumn);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        vertical(root);
        return ans;
    }
}



/*
 So will the comparator (a, b) be called?
No.

When a list has only one element, the comparator function is not called at all because:

There's no second item (b) to compare against.

Sorting 1 item = no operation needed.

This means:

Collections.sort() internally checks the size.

If size ≤ 1, it skips sorting.

So a and b don’t even get defined — the comparator is not invoked.
 */

 /*
 List of integer array
-2 → [[2, 4]]
-1 → [[1, 2]]
 0 → [[0, 1], [2, 6], [2, 5]]
 1 → [[1, 3]]
 2 → [[2, 7]]
  */