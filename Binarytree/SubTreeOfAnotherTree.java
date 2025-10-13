public class SubTreeOfAnotherTree {
    static class Node {
        int data;
        Node left;
        Node right;
  
        Node(int data) {
           this.data = data;
           this.left = null;
           this.left = null;
        }
     }
  
     public static Boolean isSubTree(Node root, Node subRoot ){
        if (root == null) {
           return false;
        }
  
        if (root.data==subRoot.data) {
           if(isIdentical(root, subRoot)){
              return true;
           }
        }
  
        // boolean left_ans = isSubTree(root.left, subRoot);
        // boolean right_ans = isSubTree(root.right, subRoot);
  
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
  
     }
  
     public static Boolean isIdentical(Node root, Node subRoot){
        if (root == null && subRoot==null) {
           return true;
        }else if (root == null || subRoot== null || root.data != subRoot.data) {
           return false;
        }
  
        // if (!isIdentical(root.left, subRoot.left)) {
        //    return false;
        // }
        // if (!isIdentical(root.right, subRoot.right)) {
        //    return false;
        // }
  
        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
     }
  
     public static void main(String[] args) {
        /*
         *      1
         *    /   \
         *   2     3
         *  / \   / \
         * 4   5 6   7
         */
  
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
  
        /*
         *    2
         *   / \
         *  4   5
         */
  
         Node subRoot = new Node(2);
         subRoot.left = new Node(4);
         subRoot.right = new Node(5);
  
         System.out.println(isSubTree(root, subRoot));
     }
}
