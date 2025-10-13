// package Heaps;

// import java.util.*;
// import java.util.PriorityQueue;

// public class practice_Session {

//     static class Sort implements Comparable<Sort> {

//         int data;
//         int i;

//         Sort(int data, int i){
//             this.data = data;
//             this.i = i;
//         }

//         public int compareTo(Sort data2){
//             return this.data - data2.data;
//         }
//     }

//     public static void main(String []args){
//         int list[][] = {
//             {1, 4, 5}, 
//             {1, 3, 4},
//             {2, 6, 7}
//         };

//         PriorityQueue<Sort> pq = new PriorityQueue<>();

//         for(int i=0; i<list.length; i++){
//             for(int j=0; j<list[i].length; j++){             //he inner loop now uses list[i].length to iterate through the actual length of each row of the 2D array, instead of list.length, which would give the number of rows.
//                 pq.add(new Sort(list[i][j], i));
//             }
//         }

//         while (!pq.isEmpty()) {
//             System.out.print(pq.peek().data + "->");
//             pq.remove();
//         }

//     }

// }

//upheapify

// import java.util.ArrayList;
// import java.util.Collections;

// public class practiceSession {
//     class Heap {
//     ArrayList<Integer> tree = new ArrayList<>();

//     void add(int val) {
//         tree.add(val);
//         upheapify(tree.size() - 1);
//     }

//     void upheapify(int idx) {
//         if(idx == 0) return;

//         int par = (idx - 1) / 2;
//         if(tree.get(idx) < tree.get(par)) {
//             Collections.swap(tree, idx, par);
//             upheapify(par);
//         }
//     }
// }

// public class Main {

//     public static void main(String[] args) {
//         System.out.println("Hello World!");

//         Heap pq = new Heap();

//         pq.add(50);
//         System.out.println(pq.tree);

//         pq.add(70);
//         System.out.println(pq.tree);

//         pq.add(60);
//         System.out.println(pq.tree);

//         pq.add(55);
//         System.out.println(pq.tree);

//         pq.add(65);
//         System.out.println(pq.tree);

//         pq.add(45);
//         System.out.println(pq.tree);

//         pq.add(48);
//         System.out.println(pq.tree);

//         pq.add(30);
//         System.out.println(pq.tree);

//     }
// }
// }

//Down Heapify

// public class practice_Session {

//     static class Heap {

//         ArrayList<Integer> list = new ArrayList<>();

//         void add(int val) {
//             list.add(val);
//             upheapify(list.size() - 1);
//         }

//         void upheapify(int idx) {
//             if (idx == 0)
//                 return;

//             int par = (idx - 1) / 2;
//             if (list.get(idx) < list.get(par)) {
//                 Collections.swap(list, idx, par);
//                 upheapify(par);
//             }
//         }

//         Integer remove() {
//             Collections.swap(list, 0, list.size() - 1);
//             Integer top = list.get(list.size()-1);
//             list.remove(list.size()-1);
//             downheapify(0);
//             return top;
//         }

//         void downheapify(int idx) {
//             int min = idx;

//             int left = idx * 2 + 1;
//             if (left < list.size() && list.get(left) < list.get(min)) {
//                 min = left;
//             }

//             int right = idx * 2 + 2;
//             if (left < list.size() && list.get(right) < list.get(min)) {
//                 min = right;
//             }

//             if (min != idx) {
//                 Collections.swap(list, min, idx);
//                 downheapify(min);
//             }
//         }
//     }

//     public static void main(String[] args) {
//         Heap pq = new Heap();

//         pq.add(50);
//         System.out.println(pq.list);

//         pq.add(70);
//         System.out.println(pq.list);

//         pq.add(60);
//         System.out.println(pq.list);

//         pq.add(55);
//         System.out.println(pq.list);

//         pq.add(65);
//         System.out.println(pq.list);

//         pq.add(45);
//         System.out.println(pq.list);

//         pq.add(48);
//         System.out.println(pq.list);

//         pq.add(30);
//         System.out.println(pq.list);

//         pq.remove();
//         System.out.println(pq.list);
//     }
// }