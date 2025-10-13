public class MirrorBST {

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

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            // left Subtree
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Mirror a BST
    public static Node mirrorBST(Node root) { // O(n)
        if (root == null) {
            return root;
        }

        root.left = mirrorBST(root.left);
        root.right = mirrorBST(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public static Node mirrorBSTS(Node root) {
    if (root == null) return null;

    mirrorBST(root.left);
    mirrorBST(root.right);

    Node temp = root.left;
    root.left = root.right;
    root.right = temp;

    return root;
}

    // preOrder
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root);

        mirrorBST(root);
        preOrder(root);
    }

}
