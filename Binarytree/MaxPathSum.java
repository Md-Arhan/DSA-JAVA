public class MaxPathSum {
    static int sum = 0;
    static int max = Integer.MIN_VALUE;

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

    public static int maximumSum(Node root) {
        if (root == null) {
            return 0;
        }

       // Recursively find the maximum path sum in left and right subtrees
    int leftSum = maximumSum(root.left);
    int rightSum = maximumSum(root.right);

    // Calculate the maximum path sum through the current node
    int currentMax = root.data + Math.max(0, leftSum) + Math.max(0, rightSum);

    // Update the global max
    max = Math.max(max, currentMax);

    // Return the maximum sum of one side (either left or right) plus the current node's value
    return root.data + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        max = Integer.MIN_VALUE;
        maximumSum(root);
        System.out.println(max);
    }
}



/* Wrong Logic dry run
 *  Dry Run Step-by-Step
Step 1: Call maxPathSum(-10)
→ calls maxPath(-10)

maxPath(-10)
left = maxPath(9)

right = maxPath(20)

maxPath(9)
left = 0

right = 0

currPath = 9 + 0 + 0 = 9

maximum = max(-∞, 9) = 9

❌ return maximum = 9 ← wrong logic, but okay for now

maxPath(20)
left = maxPath(15)

right = maxPath(7)

maxPath(15)
left = right = 0

currPath = 15 + 0 + 0 = 15

maximum = max(9, 15) = 15

❌ return maximum = 15

maxPath(7)
left = right = 0

currPath = 7 + 0 + 0 = 7

maximum = max(15, 7) = 15

❌ return maximum = 15 ← this is wrong: should be 7

 */