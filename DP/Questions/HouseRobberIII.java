package DP.Questions;

import java.util.HashMap;

import javax.swing.tree.TreeNode;

public class HouseRobberIII {
    public int dfs(TreeNode root, HashMap<TreeNode, Integer> dp) {
        if (root == null) {
            return 0;
        }

        if (dp.containsKey(root)) {
            return dp.get(root);
        }

        int nottake = dfs(root.left, dp) + dfs(root.right, dp);

        int take = root.val;

        if(root.left != null){
            take+=dfs(root.left.left, dp) + dfs(root.left.right, dp);
        }

        if(root.right != null){
            take+=dfs(root.right.left, dp) + dfs(root.right.right, dp);
        }

        int max = Math.max(take, nottake);

        dp.put(root, max);

        return max;
    }

    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> dp = new HashMap<>();

        return dfs(root, dp);
    }
}
