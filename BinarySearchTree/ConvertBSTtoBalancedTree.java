import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class ConvertBSTtoBalancedTree {
    // TC -> O(n)

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

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode slow=head,fast=head,slow_Prev=null;
        while(fast!=null && fast.next!=null){
            slow_Prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);//Making A Root Node
        slow_Prev.next = null;//Braeking The Link For L1
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        ArrayList<Integer> order = new ArrayList<>();

        inOrder(root, order);

        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i) + " ");
        }

        System.out.println();

        root = createBST(order, 0, order.size() - 1);

        preOrder(root);
    }

}
