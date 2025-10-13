public class DeleteNode {
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

    //InOrder Successor, preOrder successor is second one which finds the right most node in the left subtree
    public static Node findInOrder(Node root) {
        while (root.left != null) {
            root = root.left;
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

    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {
            // Case - 1 : leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case - 2 Single Child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case - 3
            Node IS = findInOrder(root.right);
            root.data = IS.data;
            root.right = delete(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root);

        root = delete(root, 10);
        System.out.println();

        inOrder(root);
        System.out.println();

    }
}
