public class TransfromToSumTree {
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

    public static int transformSumTree(Node root) {

        if (root == null) {
            return 0;
        }

        int trans1 = transformSumTree(root.left);
        int trans2 = transformSumTree(root.right);

        int data = root.data;

        root.data = (root.left == null ? 0 : root.left.data + trans1) + (root.right == null ? 0 : root.right.data + trans2);

        return data;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        /*
         *       1
         *     /   \
         *    2      3
         *   / \    / \
         *  4   5  6   7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transformSumTree(root);
        preOrder(root);

    }
}
