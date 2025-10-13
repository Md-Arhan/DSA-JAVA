import javax.swing.tree.TreeNode;

public class PrintInRange {
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

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // Check if the current node's value is within the range
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }

        // Traverse left subtree if the current value is greater than L
        if (root.val > L) {
            sum += rangeSumBST(root.left, L, R);
        }

        // Traverse right subtree if the current value is less than R
        if (root.val < R) {
            sum += rangeSumBST(root.right, L, R);
        }

        return sum;
    }

    // Function to calculate the range sum of BST
//     static int rangeSumBST(Node root, int low, int high) {
//         if (root == null) return 0;

//         Queue<Node> q = new LinkedList<>();
//         q.add(root);

//         while (!q.isEmpty()) {
//             Node curr = q.poll(); // Get and remove the current node

//             // Add the value if it's within the range
//             if (curr.val >= low && curr.val <= high) {
//                 sum += curr.val;
//             }

//             // Check the left child if the current value is greater than low
//             if (curr.left != null && curr.val > low) {
//                 q.add(curr.left);
//             }

//             // Check the right child if the current value is less than high
//             if (curr.right != null && curr.val < high) {
//                 q.add(curr.right);
//             }
//         }
//         return sum;
//     }

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

        printInRange(root, 5, 12);

    }

}
