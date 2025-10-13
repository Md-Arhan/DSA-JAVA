package Stacks;

import java.util.Stack;

public class ReverseStack {
    public static void pushBottom(Stack<Integer> s, int data) {

        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s) {

        if(s.isEmpty()){
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushBottom(s, top);

    }

    public static void print(Stack<Integer> s){
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        print(s);      // 3, 2, 1
        reverseStack(s);
        print(s);      //1, 2, 3
    }
}
