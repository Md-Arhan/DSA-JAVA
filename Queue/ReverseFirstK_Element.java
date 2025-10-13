package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstK_Element {
    public static void reverseElement(Queue<Integer> q, int k){
        Stack<Integer> s = new Stack<>();

        int size = q.size() - k;
        while (size > 0) {
            s.push(q.remove());
            size--;
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        for(int i=0; i<q.size()-k; i++){
            q.add(q.remove());
        }
    }


    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        reverseElement(q, 5);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
