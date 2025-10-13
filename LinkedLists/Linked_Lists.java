package LinkedLists;

import java.util.LinkedList;

// public class Linked_Lists {

//     public static void main(String []args){
//         //creating a linekd list of non-primitive data Structure
//         LinkedList<Integer> ll = new LinkedList<>();

//         //add
//         ll.addLast(1);
//         ll.addLast(2);
//         ll.addFirst(0);
//         System.out.println(ll);

//         //remove
//         // ll.removeLast();
//         // ll.removeFirst();
//         ll.removeAll(ll);
//         System.out.println(ll);
//     }
    
// }


//Assigment Question

public class Linked_Lists {

    public static void merging(LinkedList<Integer> ll, LinkedList<Integer> lls){
        if(ll == null){
            System.out.println("list is empty");
        }

        ll.addAll(lls);
        System.out.println("Merging List" + ll);
    }

    public static void main(String []args){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        LinkedList<Integer> lls = new LinkedList<>();
        lls.addLast(10);
        lls.addLast(12);

        merging(ll, lls);
    }
}