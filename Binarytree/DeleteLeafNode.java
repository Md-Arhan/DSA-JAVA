import javax.swing.tree.TreeNode;

public class DeleteLeafNode {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node deleteNodes(Node root) {
        if (root == null) {
            return null;
        }

        root.left = deleteNodes(root.left);
        root.right = deleteNodes(root.right);

        if (root.left == null && root.right == null && root.data == 3) {
            return null;
        }

        return root;

    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public TreeNode deleteNodes(TreeNode root, int target){
        if(root == null){
            return null;
        }

        TreeNode left= deleteNodes(root.left, target);
        TreeNode right = deleteNodes(root.right, target);

        if(left == null && right == null && root.val == target){
            return null;
        }

        root.left = left;
        root.right = right;

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.right = new Node(3);

        deleteNodes(root);
        inOrder(root);
    }
}




/*
 * he root is a leaf and matches the target — so it should be deleted.

deleteNodes(root, 2) returns null

But you return root (which still points to a TreeNode(2))

🛑 This is wrong — the tree should be null, but your code returns the old root!

✅ So in short:
Yes: internal nodes get their children modified in-place — that’s fine.

❌ No: the root being deleted won't reflect unless you return the updated root.
 */