package LinkedLists;

public class ChangeAndUnChanged {
    class Node {
        int data;
        
        Node(int data) {
            this.data = data;
        }
    }
    
    public class ObjectTest {
        static void modifyObject(Node node) {
            node.data = 99; // Modifies the original object
        }
    
        public static void main(String[] args) {
            Node head = new Node(10);
            modifyObject(head);
            System.out.println(head.data); // Output: 99
        }
    }

    class Node {
        int data;
    
        Node(int data) {
            this.data = data;
        }
    }
    
    public class ObjectTest {
        static void reassignObject(Node node) {
            node = new Node(50); // This does NOT change the original object
        }
    
        public static void main(String[] args) {
            Node head = new Node(10);
            reassignObject(head);
            System.out.println(head.data); // Output: 10 (unchanged)
        }
    }
}
