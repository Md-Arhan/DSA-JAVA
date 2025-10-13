package Stacks.StackImplementation;

import java.util.*;

// When we use static for data Structure and not for methods then all the insertion store in the same array even if we create different objects.
// If we dont use static for ArrayList data structure, then :  non-static variable list cannot be referenced from a static context return list.size() == 0;

/*You only need to make an inner class static if you're declaring it inside another class (like ArrayLists) and you want to use it without creating an instance of the outer class
 * If a class is declared static inside another class, it means:
   You don’t need an instance of the outer class to create an object of the inner class.
 *If your Stack class is non-static and inside another class, you must first create an instance of the outer class to use it.
*/


/*
 * If you use static variables or methods, you're saying that the data is shared among all instances of the class. This means there’s only one copy of the variable or method for the entire class, regardless of how many instances (objects) of that class are created.
 * Now, if you want each instance of Stack to have its own separate stack (independent of other instances), you should avoid using static. This way, each Stack object will have its own ArrayList, and operations on one stack will not affect another stack.
 */

 
/*An instance is just another word for an object — a real usable version of a class. */
/*public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();   // ✅ myCar is an instance of Car
        myCar.color = "Red";
        myCar.drive();           // prints: Car is driving...
    }
} */

/* if i make class stack non-static, error occurs : like
 * error: non-static variable this cannot be referenced from a static context
        Stack s = new Stack();
 */


public class ArrayLists {
    
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();

        //isEmpty  O(1)
        public static Boolean isEmpty(){
            return list.size() == 0;
        }

        //push   O(1)
        public static void push(int data){
          list.add(data);
        }

        //pop  O(1)
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size() -1);
            list.remove(list.size()-1);
            return top;
        } 

        //peek  O(1)the
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size() -1); 
        }
    }

    public static void main(String[] args) {
        // // First, create an instance of the outer class ArrayLists
        // ArrayLists outer = new ArrayLists();

        // // Now you can create an instance of the non-static inner class Stack
        // ArrayLists.Stack s1 = outer.new Stack();
        // ArrayLists.Stack s2 = outer.new Stack();

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        Stack s1 = new Stack();
        s1.push(3);
        s1.push(2);
        s1.push(1);

        System.out.println(s1.peek());

        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }
    }
}
