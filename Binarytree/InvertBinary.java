public class InvertBinary {
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

    public static Node mirrorTree(Node root){

        if (root == null) {
            return root;
        }

        Node left = mirrorTree(root.left);
        Node right = mirrorTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            // System.out.println(-1);
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
      Node root = new Node(1);
      root.left = new Node(2);
      root.left.left = new Node(5);
      root.left.right = new Node(5);
      root.right = new Node(3);
      root.right.left = new Node(6);
      root.right.right = new Node(7);

      mirrorTree(root);
      preOrder(root);
    }
}
