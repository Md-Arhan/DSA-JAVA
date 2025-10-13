package Stacks.StackUsingQueue;

public class Push_O(n) {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();
  
        //isEmpty
        public static Boolean isEmpty(){
          return q1.isEmpty() && q2.isEmpty();
        }
  
        //add
        public static void push(int data){
  
          if (q1.isEmpty()) {
              q1.add(data);
              while (!q2.isEmpty()) {
                  q1.add(q2.remove());
              }
          }else{
              q2.add(data);
              while (!q1.isEmpty()) {
                  q2.add(q1.remove());
              }
          }
        }
  
        public static int pop(){
          if (isEmpty()) {
              System.out.println("Queue empty");
              return -1;
          }
  
          int val;
  
          if (!q1.isEmpty()) {
              val = q1.remove();
          }else{
              val = q2.remove();
          }
  
          return val;
        }
  
        public static int peek(){
          if (isEmpty()) {
              System.out.println("Queue empty");
              return -1;
          }
  
          int val;
  
          if (!q1.isEmpty()) {
              val = q1.peek();
          }else{
              val = q2.peek();
          }
  
          return val;
        }
      }
  
      public static void main(String[] args) {
          Stack s = new Stack();
          s.add(1);
          s.add(2);
          s.add(3);
  
          while (!s.isEmpty()) {
              System.out.println(s.pop());
          }
      }
}
