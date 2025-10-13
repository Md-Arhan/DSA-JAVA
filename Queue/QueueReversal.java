package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {
    
    public static void reversal(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

    }

    public static void reverseKelement(Queue<Integer> q, int k){
        helper(q, k);
        int size = q.size() - k;
        while (size-- > 0) {
            q.add(q.poll());
        }
        
    }

    public static void helper(Queue<Integer> q, int k){
       //Base case
       if (k == 0) {
        return;
       }

       int front = q.poll();
       helper(q, k-1);
       q.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reversal(q);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }

    }
}
