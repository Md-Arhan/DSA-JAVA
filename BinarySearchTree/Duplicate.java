import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Duplicate {
    class Solution {
    private Integer prevVal = null;
    private int currCount = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        // Convert result list to array
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        if (prevVal != null && node.val == prevVal) {
            currCount++;
        } else {
            currCount = 1;
        }

        if (currCount > maxCount) {
            maxCount = currCount;
            modes.clear();
            modes.add(node.val);
        } else if (currCount == maxCount) {
            modes.add(node.val);
        }

        prevVal = node.val;

        inOrder(node.right);
    }
}

}
