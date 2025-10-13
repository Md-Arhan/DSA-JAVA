import java.util.ArrayList;
import java.util.Collections;

public class MergeBST {  // TC -> O(n+m) -> Linear Time
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

    // inOrder
    public static void inOrder(Node root, ArrayList<Integer> order) {
        if (root == null) {
            return;
        }

        inOrder(root.left, order);
        order.add(root.data);
        inOrder(root.right, order);
    }

    public static Node createBST(ArrayList<Integer> arr, int si, int ei) {
        if (si > ei) {
            return null;
        }

        int mid = (si + ei) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, si, mid - 1);
        root.right = createBST(arr, mid + 1, ei);
        return root;
    }

    // preOrder
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(4);

        Node root1 = new Node(9);
        root1.left = new Node(3);
        root1.right = new Node(12);

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        inOrder(root, list1);
        inOrder(root1, list2);

        list1.addAll(list2);

        /*
         * // Sorting Technique
         * ArrayList<Integer> final1 = new ArrayList<>();
         * int i = 0, j = 0;
         * while (i < list1.size() && j < list2.size()) {
         * if (list1.get(i) <= list2.get(i)) {
         * final1.add(list1.get(i));
         * i++;
         * } else {
         * final1.add(list2.get(i));
         * j++;
         * }
         * }
         * 
         * while (i < list1.size()) {
         * final1.add(list1.get(i));
         * i++;
         * }
         * 
         * while (j < list2.size()) {
         * final1.add(list2.get(i));
         * j++;
         * }
         */

        // inBuild Sorting Technique
        Collections.sort(list1, (a, b) -> a - b);

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();

        root = createBST(list1, 0, list1.size() - 1);

        preOrder(root);
    }
}