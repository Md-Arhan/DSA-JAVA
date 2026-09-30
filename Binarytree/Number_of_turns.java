public class Number_of_turns {
    /*
     * Structure of Binary Tree Node
     * class Node {
     * int data;
     * Node left;
     * Node right;
     * 
     * Node(int val) {
     * data = val;
     * left = right = null;
     * }
     * }
     */

    class Solution {

        private Node LCA(Node root, int p, int q) {
            if (root == null) {
                return null;
            }

            if (root.data == p || root.data == q) {
                return root;
            }

            Node left = LCA(root.left, p, q);
            Node right = LCA(root.right, p, q);

            if (left == null) {
                return right;
            }

            if (right == null) {
                return left;
            }

            return root;
        }

        private int dfs(Node root, int target, char curr) {
            if (root.data == target) {
                return 0;
            }

            if (root.left != null) {
                int left = dfs(root.left, target, 'L');

                if (left != -1) {
                    if (curr == 'R') {
                        left++;
                    }
                    return left;
                }

            }

            if (root.right != null) {
                int left = dfs(root.right, target, 'R');

                if (left != -1) {
                    if (curr == 'L') {
                        left++;
                    }
                    return left;
                }

            }

            return -1;
        }

        public int numberOfTurns(Node root, int p, int q) {
            // code here
            Node Par = LCA(root, p, q);

            if (Par.data == p) {
                int res = dfs(Par, q, 'N');
                return res == 0 ? -1 : res;
            }
            if (Par.data == q) {
                int res = dfs(Par, p, 'N');
                return res == 0 ? -1 : res;
            }

            int res1 = dfs(Par, p, 'N');
            int res2 = dfs(Par, q, 'N');

            if (res1 == -1 || res2 == -1) {
                return -1;
            }

            return res1 + res2 + 1;
        }
    }

}
