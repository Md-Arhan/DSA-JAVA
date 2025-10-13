import javax.swing.tree.TreeNode;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if(root.left == null){
            return minDepth(root.right) +1;
        }

        if(root.right == null){
            return 1 + minDepth(root.left);
        }

        return 1+ Math.min(minDepth(root.left), minDepth(root.right));
    }
}
