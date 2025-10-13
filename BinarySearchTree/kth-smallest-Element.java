public class kth-smallest-Element {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

        static int count = 0; // Counter to keep track of the number of elements visited
        static int result = -1; // To store the K-th smallest value

        // Function to find the K-th smallest element in the BST
        static void findKthSmallest(Node root, int k) {
            if (root == null) {
                return;
            }

            // Traverse the left subtree
            findKthSmallest(root.left, k);

            // Increment the count and check if we have reached the K-th element
            count++;
            if (count == k) {
                result = root.val;
                return;
            }

            // Traverse the right subtree
            findKthSmallest(root.right, k);
        }

        // Helper function to insert a node in BST
        static Node insert(Node node, int data) {
            if (node == null) return new Node(data);

            if (data <= node.val) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
            return node;
        }

        public static void main(String[] args) {
            // Construct the BST
            Node root = null;
            root = insert(root, 8);
            root = insert(root, 5);
            root = insert(root, 11);
            root = insert(root, 3);
            root = insert(root, 6);
            root = insert(root, 20);

            // Find the K-th smallest element
            int k = 3; // Example 1
            count = 0; // Reset the counter
            result = -1; // Reset the result
            findKthSmallest(root, k);
            System.out.println("K-th Smallest Element (K=3): " + result); // Output: 8

            k = 5; // Example 2
            count = 0; // Reset the counter
            result = -1; // Reset the result
            findKthSmallest(root, k);
            System.out.println("K-th Smallest Element (K=5): " + result); // Output: 11
        }
}
