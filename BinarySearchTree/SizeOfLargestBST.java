import javax.swing.tree.TreeNode;

public class SizeOfLargestBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info{
        Boolean isBST;
        int size = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        Node root;

        Info(boolean isBST, int size, int min, int max, Node root){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
            this.root = root;
        }
    }

    public static int maxBST = 0;
    static Node largestBST = null;

    public static Info largestBST(Node root){
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, null);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        //inValid Condition
        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max, root);
        }

        //Valid Condition
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            largestBST = root;
            return new Info(true, size, min, max, root);
        }

        return new Info(false, size, min, max, root);

    }


    /*"Instead of just checking root.val <= left.max || root.val >= right.min, shouldn't we check the rightmost node of the left subtree and the leftmost node of the right subtree? Because otherwise, we're only comparing at the current level and not truly verifying the full BST condition." */
    public Info max(TreeNode root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        Info left = max(root.left);
        Info right = max(root.right);

        int sum = left.count + right.count + root.val;
        int minimum = Math.min(root.val, Math.min(left.min, right.min));
        int maximum = Math.max(root.val, Math.max(left.max, right.max));

        if(root.val <= left.max || root.val >= right.min){
            return new Info(false, sum, minimum, maximum);
        }

        if(left.isTrue && right.isTrue){
            max = Math.max(max, sum);
            return new Info(true, sum, minimum, maximum);
        }

        return new Info(false, sum, minimum, maximum);
    }

    public static void printNodes(Node root) {
        if (root == null) return;
        printNodes(root.left);
        System.out.print(root.data + " ");
        printNodes(root.right);
    }

    public static void main(String[] args){
       Node root = new Node(50);
       root.left = new Node(30);
       root.left.left = new Node(5);
       root.left.right = new Node(20);

       root.right = new Node(60);
       root.right.left = new Node(45);
       root.right.right = new Node(70);
       root.right.right.left = new Node(65);
       root.right.right.right = new Node(80);

       /*
            60
           /  \
          45   70
              /  \
             65   80

             expected BST = 5;

        */

        Info info = largestBST(root);
        System.out.println("Largest BST size = " + maxBST);
        printNodes(largestBST);

        // printNodes(root.right.right);

    }
}
