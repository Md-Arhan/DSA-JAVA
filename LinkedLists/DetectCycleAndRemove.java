package LinkedLists;

public class DetectCycleAndRemove {
    public static class Node { // --> this is a nested class
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Boolean isCycle() {  //Flyods cycle algorithm
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void removeCycle() {

        // detect cycle
        Node slow = head;
        Node fast = head;
        Boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        // find meeting point
        slow = head;
        Node prev = null;  //prev = last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle -> last.next = null;
        prev.next = null;
    }
}
