package LinkedLists;

public class Operations {
    public void print() { // O(n)

        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static class Node { // --> this is a nested class
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head; // --> object of data
    public static Node tail; // --> object of next
    public static int size;

    public void addFirst(int data) {

        // Step 1 = create new node
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Step 2 = newNode.next = head;
        newNode.next = head;

        // Step 3 = head = newNode
        head = newNode;

    }

    public void addLast(int data) {
        // Step 1 = create new node
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Step 2 = tail.next = tail;
        tail.next = newNode;

        // Step 3 = tail = newNode
        tail = newNode;

    }

    public void addAtIndex(int idx, int data) {

        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {

        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;

    }

    public int removeLast() {

        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // prev
        Node prev = head; // prev is temp;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }

    public static void main(String[] args) {
        //         // LinkedLists ll = new LinkedLists();
        //         // ll.head = new Node(1);
        //         // ll.head.next = new Node(2);
        //         // // ll.print();
        
        //         // addFirst
        //         // ll.addFirst(2);
        //         // ll.addFirst(1);
        
        //         // // addLast
        //         // ll.addLast(3);
        //         // ll.addLast(4);
        //         // ll.addLast(5);
        //         // ll.print();
        
        //         // add at index
        //         // ll.addAtIndex(2, 9);
        
        //         // System.out.println(ll.size);
        
        //         // removing nodes
        //         // ll.removeFirst();
        //         // ll.removeLast();
        
        //         // Linear Search -->O(n)
        //         // System.out.println(ll.searchKey(size, 3));
        //         // System.out.println(ll.searchKey(size, 10));
        
        //         // Recursion //TC & SC -> O(n)
        //         // System.out.println(ll.recursiveSearch(3));
        //         // System.out.println(ll.recursiveSearch(10));
        
        //         // reverse TC -> O(n)
        //         // ll.reverse();
        //         // ll.print();
        
        //         // Recursive reverse
        //         // ll.reverseRecursive();
        //         // ll.print();
        
        //         // deleteNthfromEnd
        //         // ll.deleteNthfromEnd(3);
        //         // ll.print();
        
        //         // isPalindrome
        //         // System.out.println(ll.checkPalindrome());
        
        //         // Floyds Cycle algorithm :
        //         // LinkedLists ll = new LinkedLists();
        //         // head = new Node(1);
        //         // head.next = new Node(2);
        //         // head.next.next = new Node(3);
        //         // head.next.next.next = head;
        
        //         // System.out.println(ll.isCycle());
        
        //         // Remove Cycle
        //         // head = new Node(1);
        //         // Node temp = new Node(2);
        //         // head.next = temp;
        //         // head.next.next = new Node(3);
        //         // head.next.next.next = temp;
        
        //         // removeCycle();
        //         // System.out.println(isCycle());
        
        //         // Merge sort
        
        //         // LinkedLists ll = new LinkedLists();
        //         // ll.addFirst(1);
        //         // ll.addFirst(2);
        //         // ll.addFirst(3);
        //         // ll.addFirst(4);
        //         // ll.addFirst(5);
        
        //         // ll.print();
        
        //         // ll.head = ll.mergeSort(ll.head);
        //         // ll.print();
        
        //         // ZigZag
        //         // LinkedLists ll = new LinkedLists();
        //         // ll.addLast(1);
        //         // ll.addLast(2);
        //         // ll.addLast(3);
        //         // ll.addLast(4);
        //         // ll.addLast(5);
        //         // ll.addLast(6);
        
        //         // ll.print();
        //         // ll.zigZag();
        //         // ll.print();
        
        //     }
}
