public class ReverseKNodes {
    public Node reverseKGroup(Node head, int k) {
        // code here
        int count = 0;
        Node curr = head;
        if(head == null){
            return null;
        }
        
        Node prev = null;
        Node next = null;
        
        while(curr != null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        if(next != null){
            head.next = reverseKGroup(next, k);
        }
        
        return prev;
    }
}
