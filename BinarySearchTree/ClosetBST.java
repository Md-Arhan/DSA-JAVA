
public class ClosetBST {
    
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

    static int sum = 0;
    public static int closest = Integer.MAX_VALUE;

    public static int closestPath(Node root, int target){

        while (root != null) {
            // Update closest if the current node is closer to the target
            if (Math.abs(root.data - target) < Math.abs(closest - target)) {
                closest = root.data - target;
            }

            // Move left or right depending on the target's value
            if (target < root.data) {
                root = root.left;
            } else if (target > root.data) {
                root = root.right;
            } else {
                // Exact match found
                return root.data;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);

        closestPath(root, 5);
        System.out.println(closest);
    }
}