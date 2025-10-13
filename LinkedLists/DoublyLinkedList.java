package LinkedLists;

public class DoublyLinkedList {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public int removeFirst() {
        if (head == null) {
            return 0;
        }

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val
    }

    public void removeLast() {
        if (head == null) { // Empty list case
            return;
        }
    
        if (size == 1) { // Single node case
            head = tail = null;
        } else {
            tail = tail.prev; // Move tail backward
            tail.next = null; // Disconnect old tail
        }
    }

    // print
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverseList() {

        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;

    }

    public static void main(String[] args) {
        LinkedLists dll = new LinkedLists();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        // dll.removeFirst();
        // dll.removeLast();
        // dll.addLast(4);
        dll.print();
        dll.reverseList();
        dll.print();
        System.out.println(size);
    }
}
