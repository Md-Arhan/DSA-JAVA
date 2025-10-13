import javax.swing.tree.TreeNode;

public class uniValued {
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

    public static Boolean uniValued(Node root){

        if (root == null) {
            return true;
        }

        if (root.left != null && root.data != root.left.data) {
            return false;
        }

        if (root.right != null && root.data != root.right.data) {
            return false;
        }

        return uniValued(root.left) && uniValued(root.right);
    }

    public static void main(String[] args) {
      Node root = new Node(2);
      root.left = new Node(2);
      root.left.left = new Node(2);
      root.left.right = new Node(2);
      root.right = new Node(2);
      System.out.println(uniValued(root));
    }
}
