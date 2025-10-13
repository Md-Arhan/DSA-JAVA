package LinkedLists;

public class Assignment {

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

    public static Node merging(Node head1, Node head2) {   
        if (head1 == null) {
            System.out.println("List is empty");
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node temp = head1;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head2;

        return head1;
    }

    public void deletingNodes(Node head, int m, int n) {
        Node curr = head;
        int count;

        while (head != null) {
            // Skip `m` nodes
            for (count = 1; count < m && curr != null; count++) {
                curr = curr.next;
            }

            // If we've reached the end of the list, break
            if (curr == null) {
                return;
            }

            // Start deleting the next `n` nodes
            Node temp = curr.next; // The node after the mth node
            for (count = 1; count <= n && temp != null; count++) {
                temp = temp.next; // Move temp forward to skip n nodes
            }

            // Connect the mth node to the node after the skipped/deleted n nodes
            curr.next = temp;

            // Move the current pointer to the next segment
            curr = temp;

        }

    }

    public void swapNodes(int x, int y) {
        // If x and y are the same, no need to swap
        if (x == y)
            return;

        // Search for x and y in the linked list and keep track of their previous nodes
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not found, return
        if (currX == null || currY == null)
            return;

        // If x is not the head, link its previous node to y
        if (prevX != null) {
            prevX.next = currY; // 1 and 4 swapped
        } else { // Else make y the new head
            head = currY;
        }

        // If y is not the head, link its previous node to x
        if (prevY != null) {
            prevY.next = currX; // 3 and 2
        } else { // Else make x the new head
            head = currX;
        }

        // Swap the next pointers of currX and currY // 3 will left it will swap with
        // null
        Node temp = currX.next; // 3
        currX.next = currY.next; // 3.next(4) = null
        currY.next = temp; // 3.next(4) = 3 now 1->4->3->2
    }

    public void oddEvenList() {
        if (head == null || head.next == null) {
            return; // No need to modify for empty or single-node list
        }

        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;
        Node current = head;

        // Traverse the list and segregate even and odd nodes
        while (current != null) {
            if (current.data % 2 == 0) { // Even node
                if (evenHead == null) {
                    evenHead = evenTail = current; // Initialize even list
                } else {
                    evenTail.next = current;
                    evenTail = evenTail.next;
                }
            } else { // Odd node
                if (oddHead == null) {
                    oddHead = oddTail = current; // Initialize odd list
                } else {
                    oddTail.next = current;
                    oddTail = oddTail.next;
                }
            }
            current = current.next;
        }

        // If there are no even numbers, keep the odd list as is
        if (evenHead == null) {
            head = oddHead;
            return;
        }

        // Connect even list to odd list
        evenTail.next = oddHead;
        if (oddTail != null) {
            oddTail.next = null; // Terminate the odd list
        }

        // Update head to the new evenHead
        head = evenHead;
    }

    public static Node SortedMerge(Node a, Node b) {
        Node result = null;

        // Base cases: one of the lists is null
        if (a == null)
            return b;
        else if (b == null)
            return a;

        // Recur to find the merged sorted list
        if (a.data <= b.data) {
            result = a;
            result.next = SortedMerge(a.next, b); // Merge remaining nodes
        } else {
            result = b;
            result.next = SortedMerge(a, b.next); // Merge remaining nodes
        }

        return result;
    }

    // Merge K sorted linked lists
    public static Node mergeKLists(Node arr[], int last) {
        
        while (last != 0) {
            int i = 0, j = last;

            // Merge lists in pairs
            while (i < j) {
                arr[i] = SortedMerge(arr[i], arr[j]); // Merge arr[i] and arr[j]
                i++;
                j--;

                // Adjust 'last' to reflect remaining unsorted lists
                if (i >= j)
                    last = j;
            }
        }

        return arr[0]; // Return the merged list  //we can directly return a array only including data
    }
    
    public static void main(String[] args) {
        //Assigment Question
        // Q1 : TC -> O(m*n)
        // Node head1 = new Node(1);
        // head1.next = new Node(2);
        // head1.next.next = new Node(3);
        // head1.next.next.next = new Node(4);
        // head1.next.next.next.next = new Node(5);

        // Node head2 = new Node(7);
        // head2.next = new Node(8);

        // Node merginHeads = merging(head1, head2);
        // Node temp = merginHeads;
        // do{
        // System.out.print(temp.data + "->");
        // temp = temp.next;
        // }while(temp!=null);
        // System.out.println("null");

        // Q2 : TC -> O(n)
        // LinkedLists ll = new LinkedLists();
        // ll.addFirst(8);
        // ll.addFirst(7);
        // ll.addFirst(6);
        // ll.addFirst(5);
        // ll.addFirst(4);
        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addFirst(1);

        // ll.deletingNodes(head, 2, 2);
        // ll.print();

        // Q3 : TC -> O(n)
        // LinkedLists ll = new LinkedLists();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.swapNodes(2, 4);
        // ll.print();

        // Q4 : TC -> O(n)
        // LinkedLists ll = new LinkedLists();
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.oddEvenList();
        // ll.print();

        // Q5 : TC -> O(n*logK)
        // int k = 3; // Number of lists
        // int n = 4; // Number of elements in each list

        // Node arr[] = new Node[k];

        // // Initialize K sorted lists
        // arr[0] = new Node(1);
        // arr[0].next = new Node(3);
        // arr[0].next.next = new Node(5);
        // arr[0].next.next.next = new Node(7);

        // arr[1] = new Node(2);
        // arr[1].next = new Node(4);
        // arr[1].next.next = new Node(6);
        // arr[1].next.next.next = new Node(8);

        // arr[2] = new Node(0);
        // arr[2].next = new Node(9);
        // arr[2].next.next = new Node(10);
        // arr[2].next.next.next = new Node(11);

        // // Merge K lists
        // Node head = mergeKLists(arr, k - 1);

        // Print the merged list
        // Node temp = head;
        // do {
        //     System.out.print(temp.data + "->");
        //     temp = temp.next;
        // } while (temp != null);
        // System.out.println("null");
    }
}
