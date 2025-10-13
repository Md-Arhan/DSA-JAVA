import java.util.HashMap;

public class FindAllDuplicates {
    //Your code is almost correct, but there is a critical bug: you're not adding the return values of the left and right subtree recursive calls to the str.
    static HashMap<String , Integer> m;

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

    public static String inOrder(Node root){
        if (root == null) {
            return "";
        }

        String str = "(";
        str+= inOrder(root.left);
        str+= Integer.toString(root.data);
        str+= inOrder(root.right);
        str+= ")";

        if (m.get(str)!=null && m.get(str) == 1) {
            System.out.println(root.data);
        }

        if (m.containsKey(str)) {
            m.put(str, m.get(str)+1);
        }else{
            m.put(str, 1);
        }

        return str;
    }

    public static void printAllDuplicate(Node root){
        m = new HashMap<>();
        inOrder(root);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.left.left = new Node(3);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(3);
        root.right.right = new Node(3);

        printAllDuplicate(root);
    }
}
