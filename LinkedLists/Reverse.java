package LinkedLists;

public class Reverse {
    public static class Node { // --> this is a nested class
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void reverseRecursive() {
        head = reverseRecursiveHelper(head);i w
    }

    public Node reverseRecursiveHelper(Node current) {

        // Base case: if the list is empty or has only one node
        if (current == null || current.next.next == null) {
            return current;
        }

        // Recursive call to reverse the rest of the list
        Node newHead = reverseRecursiveHelper(current.next);

        // Reverse the link
        current.next.next = current;
        current.next = null;

        return newHead; // Return the new head of the reversed list
    }
}
