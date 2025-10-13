package LinkedLists;

public class SearchKey {
    public static class Node { // --> this is a nested class
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int searchKey(int data, int key) {
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    public int recursiveSearch(int key) {
        return helper(head, key);

        /*
         * Java, the head pointer itself does not change in the calling function when
         * using recursion unless we explicitly return and reassign it. This is because
         * Java is strictly pass-by-value, meaning the reference to head is passed by
         * value.
         * 
         * Recursive Calls and Head Pointer – Does It Change?
         * When a function is called recursively, a copy of the reference (not the
         * actual reference) is passed. If we modify the next pointer of nodes, it
         * affects the original linked list. However, if we assign a new node to head,
         * it only changes the local copy, not the actual head in the caller.
         * 
         * public static void updateNext(ListNode head) {
         * head.next = new ListNode(99); // This modifies the original list structure
         * }
         * 
         * public static void main(String[] args) {
         * ListNode head = new ListNode(1);
         * head.next = new ListNode(2);
         * updateNext(head);
         * System.out.println(head.next.val); // Output: 99
         * }
         * 
         * public static void reassignHead(ListNode head) {
         * head = new ListNode(42); // Only changes the local copy of the reference
         * }
         * 
         * public static void main(String[] args) {
         * ListNode head = new ListNode(1);
         * reassignHead(head);
         * System.out.println(head.val); // Output: 1 — not changed
         * }
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * //Arrays
         * If you modify the contents of the array inside a method, those changes will
         * reflect in the original array. ✅
         * 
         * If you assign a new array to the local reference inside the method, it will
         * not change the original array in the caller. ❌
         * 
         * public static void modifyArray(int[] arr) {
         * arr = new int[]{10, 20, 30}; // Reassignment: this does NOT affect original
         * array
         * }
         * 
         * public static void main(String[] args) {
         * int[] original = {1, 2, 3};
         * modifyArray(original);
         * System.out.println(Arrays.toString(original)); // Output: [1, 2, 3]
         * }
         * 
         * Yes! When you call a recursive function with index + 1, it creates a new
         * function call with its own local variables, but it does not automatically
         * create a new array unless explicitly done.
         */
    }

    public int helper(Node head, int key) { // O(n)
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }
}
