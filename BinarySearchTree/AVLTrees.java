public class AVLTrees {

    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return root.height;
    }

    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }

        return height(root.left) - height(root.right);
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // Duplicate keys are not allowed
        }

        // Update root height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get root's balance factor
        int bf = getBalance(root);

        // Left Left Case
        if (bf > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        // Right Right Case
        if (bf < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        // Left Right Case
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root; // Return if AVL is balanced
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
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*
         *     30
         *    /  \
         *   20   40
         *  /  \    \
         * 10  25    50
         */

        preOrder(root);
    }
}


/*
 * Yes, you're absolutely right — in the given AVL Tree implementation, height updates are recalculated during:

Each insertion:
As the recursion unwinds, the code updates the height of each node visited:

root.height = 1 + Math.max(height(root.left), height(root.right));
This happens for every node up the recursive stack.

During rotations:
In both leftRotate and rightRotate, the height of the affected nodes (x, y) is explicitly recalculated after the rotation:

x.height = Math.max(height(x.left), height(x.right)) + 1;
y.height = Math.max(height(y.left), height(y.right)) + 1;
 */



//Height Updation

 /*
  *public static Node leftRotate(Node x) {
    Node y = x.right;  // y = 40
    Node T2 = y.left;  // T2 = null

    y.left = x;        // 40.left = 30
    x.right = T2;      // 30.right = null

    // Update heights
    x.height = Math.max(height(x.left), height(x.right)) + 1;
    y.height = Math.max(height(y.left), height(y.right)) + 1;

    return y;
}
Now calculate actual heights:

x = 30, now has no right child and no left child → height = max(0, 0) + 1 = 1

y = 40, left child is 30 (height 1), right child is 50 (height 1) →
height = max(1, 1) + 1 = 2
  */