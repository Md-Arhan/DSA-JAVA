public class FlattendLinkedList {
    /*
     * class Node {
     * int data;
     * Node next;
     * Node bottom;
     * 
     * Node(int x) {
     * data = x;
     * next = null;
     * bottom = null;
     * }
     * }
     */
    class Solution {

        Node merge(Node a, Node b) {

            Node dummy = new Node(0);
            Node temp = dummy;

            while (a != null && b != null) {

                if (a.data <= b.data) {
                    temp.bottom = a;
                    a = a.bottom;
                } else {
                    temp.bottom = b;
                    b = b.bottom;
                }

                temp = temp.bottom;
            }

            if (a != null)
                temp.bottom = a;
            else
                temp.bottom = b;

            return dummy.bottom;
        }

        Node flatten(Node root) {

            if (root == null || root.next == null)
                return root;

            // flatten remaining list
            root.next = flatten(root.next);

            // merge two sorted lists
            root = merge(root, root.next);

            return root;
        }
    }

}
