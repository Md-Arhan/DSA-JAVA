package Stacks;

import java.util.Stack;

public class PushAtBottom {

    public static void pushBottoms(Stack<Integer> s, int data){

        if(s.isEmpty()){
           s.push(data);
           return;
        }

        int top = s.pop();
        pushBottoms(s, data);
        s.push(top);

        //Not possible bcz after going to last index it will add to the top itself
        // int siz = s.size();

        // for(int i=0; i<siz; i++){
        //     if(i==s.size()-1){
        //         s.push(data);
        //     }
        // }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushBottoms(s, 4);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }
}
