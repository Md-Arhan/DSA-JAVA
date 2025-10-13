import javax.swing.tree.TreeNode;

public class DistributeCoins {
    int count = 0;

    public int dfs(TreeNode root){
       if(root == null){
        return 0;
       }

       int leftTree = dfs(root.left);
       int rightTree = dfs(root.right);

       count+= Math.abs(leftTree) + Math.abs(rightTree);

       return root.val-1 + leftTree + rightTree;
    }
    
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return count;
    }
}
