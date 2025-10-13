package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.tree.TreeNode;

// public class practice_Session {

//     public static void main(String[] args) {
//         HashMap<String, Integer> map = new HashMap<>();

//         map.put("India", 40);

//         int x = map.getOrDefault("India", 41);

//         System.out.println(map);
//         System.out.println(x);

//     }
// }

// Two sum

// public class practice_Session {

//     public static void main(String[] args) {
//         int arr[] = { 2, 7, 11, 15 };
//         int target = 9;

//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int i = 0; i < arr.length; i++) {

//             int curr = arr[i];
//             int remainingSum = target - curr;

//             // Check if the complement exists in the map
//             if (map.containsKey(remainingSum)) {
//                 System.out.println(map.get(remainingSum) + ", " + i);
//                 return; // Exit once the pair is found
//             }
//             // Store the current value and its index in the map
//             map.put(curr, i);
//         }
//     }
// }

//Sort Character by frequency

// public class practice_Session {

//     public static void main(String[] args) {
//         String s = "tree";
//         int maxFreq = Integer.MIN_VALUE;

//         HashMap<Character, Integer> map = new HashMap<>();

//         for(int i=0; i<s.length(); i++){
//             char ch = s.charAt(i);
//             if (map.containsKey(ch)) {
//                 map.put(ch, map.get(ch) + 1);
//             }else{
//                 map.put(ch, 1);
//             }
//         }

//         //Getting all the keys from map
//         ArrayList<Character> keys = new ArrayList<>(map.keySet());

//         PriorityQueue<Character> pq = new PriorityQueue<>((Character t, Character o) -> {
//             return map.get(o) - map.get(t);
//         });

//         for(int i=0; i<keys.size(); i++){
//             pq.add(keys.get(i));             // we are taking keys.get(i) not the map.get to get the value
//         }

//         // while (!pq.isEmpty()) {
//         //     System.out.println(pq.remove());
//         // }

//         StringBuilder sb = new StringBuilder();

//         while (pq.size() > 0) {
//             char ch = pq.remove();
//             int fre = map.get(ch);

//             while (fre > 0) {
//                 sb.append(ch);
//                 fre--;
//             }
//         }

//         for(int i=0; i<sb.length(); i++){
//             System.out.print(sb.charAt(i));
//         }
//     }
// }

//Bottom View

public class practice_Session {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info{
        TreeNode treeNode;
        int hd;

        Info(TreeNode treeNode, int hd){
           this.treeNode = treeNode;
           this.hd = hd;
        }
    }

    public static void bottomView(TreeNode root){
        if (root == null) return;

        // Level Order Traversal
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Add root node with horizontal distance 0
        q.add(new Info(root, 0));

        while (!q.isEmpty()) {
            Info curr = q.poll();

           if (curr == null) {
                // End of a level
                if (q.isEmpty()) break; // Stop if the queue is empty
                q.add(null); // Add null for the next level
            } else {
                // Update the map for the current node's horizontal distance
                map.put(curr.hd, curr.treeNode.data);

                // Add left child to queue with hd - 1
                if (curr.treeNode.left != null) {
                    q.add(new Info(curr.treeNode.left, curr.hd - 1));
                }

                // Add right child to queue with hd + 1
                if (curr.treeNode.right != null) {
                    q.add(new Info(curr.treeNode.right, curr.hd + 1));
                }
            }
        }

        // Print the bottom view sorted by horizontal distance
        map.keySet().stream().sorted().forEach(hd -> System.out.print(map.get(hd) + " "));
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        bottomView(root);
    }
}