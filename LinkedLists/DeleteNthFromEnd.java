package LinkedLists;

public class DeleteNthFromEnd {
    public static class Node { // --> this is a nested class
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void deleteNthfromEnd(int n) {
        // Calculate size;
        int sze = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            sze++;
        }

        if (n == sze) {
            head = head.next; // remove First, if we want to delete the head, when n is == head
            return;
        }

        // sze - n
        int i = 1;
        int iToFind = size - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }
}
