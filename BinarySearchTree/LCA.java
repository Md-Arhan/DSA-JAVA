public class LCA {
    /*
     * class Node {
     * int data;
     * Node left;
     * Node right;
     * 
     * Node(int data) {
     * this.data = data;
     * left = null;
     * right = null;
     * }
     * }
     */

    class Solution {

        public Node lca(Node root, int n, int m) {
            if (root == null) {
                return null;
            }

            if (root.data > n && root.data > m) {
                return lca(root.left, n, m);
            }

            if (root.data < n && root.data < m) {
                return lca(root.right, n, m);
            }

            return root;
        }

        public Node LCA(Node root, Node n1, Node n2) {
            // code here
            return lca(root, n1.data, n2.data);
        }
    }
}

/*
 * Why this is “only root-based”
 * 
 * At every step, you only ask:
 * 
 * 👉 “Where do both nodes lie relative to this root?”
 * 
 * Both smaller → go left
 * Both greater → go right
 * Otherwise → stop
 */