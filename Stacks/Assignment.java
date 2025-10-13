package Stacks;

// import java.util.Stack;

// public class Assignment {

//      static class Node{
//         char data;
//         Node next;

//         public Node(char data){
//             this.data = data;
//             this.next = null;
//         }
//     }

//     public Node head;
//     public Node tail;

//     static Boolean isPalindrome(Node head){
//        Stack<Character> s = new Stack<>();
//         Node slow = head;

//         while (slow!=null) {
//             s.push(slow.data);
//             slow = slow.next;
//         }

//         while (head!=null) {
//             char ch = s.pop();
//             if (head.data != ch) {
//                 return false;
//             }
//             head = head.next;
//         }

//         return true;
//     }

//     public static void main(String[] args) {
//         Node one = new Node('a');
//         Node two = new Node('b');
//         Node three = new Node('c');
//         Node four = new Node('h');
//         Node five = new Node('a');
//         one.next = two;
//         two.next = three;
//         three.next = four;
//         four.next = five;

//         Boolean isTrue = isPalindrome(one);
//         System.out.println(isTrue);

//     }

// }
