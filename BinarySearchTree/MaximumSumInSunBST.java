public class MaximumSumInSunBST {
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

    static class Info {
        Boolean isBST;
        int size = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        Node root;

        Info(boolean isBST, int size, int min, int max, Node root) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
            this.root = root;
        }
    }

    public static Boolean isValid(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }

        else if (max != null && root.data >= max.data) {
            return false;
        }

        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }

    public static int maxBST = 0;
    static Node largestBST = null;
    public static int max = Integer.MIN_VALUE;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, null);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // inValid Condition
        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max, root);
        }

        // Valid Condition
        if (leftInfo.isBST && rightInfo.isBST) {
            // maxBST = Math.max(maxBST, size);
            // largestBST = root;
            return new Info(true, size, min, max, root);
        }

        return new Info(false, size, min, max, root);

    }

    public static Boolean maximumSumBst(Node root){
        if (root == null) {
            return true;
        }

        maximumSumBst(root.left);
        maximumSumBst(root.right);

        Info isBST = largestBST(root);

        if (isBST.isBST == true) {
            max = Math.max(max, root.data);
        }

        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(9);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.right.right = new Node(3);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);

        maximumSumBst(root);
        System.out.println(max);
    }
}
