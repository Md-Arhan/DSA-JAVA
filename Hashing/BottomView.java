package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import Hashing.BottomView.Pair;

public class BottomView {
     static class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

 static class Pair {
    Node node;
    int hd;

    public Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class BottomView {
    
    class Solution {
    class TreeNode {
        int val;
        TreeNode left, right;
    }

    class Pair {
        int val, depth;
        Pair(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }

    Map<Integer, Pair> map = new TreeMap<>();

    public void dfs(TreeNode node, int hd, int depth) {
        if (node == null) return;

        if (!map.containsKey(hd) || depth >= map.get(hd).depth) {
            map.put(hd, new Pair(node.val, depth));
        }

        dfs(node.left, hd - 1, depth + 1);
        dfs(node.right, hd + 1, depth + 1);
    }

    public List<Integer> bottomView(TreeNode root) {
        dfs(root, 0, 0);
        List<Integer> result = new ArrayList<>();
        for (Pair p : map.values()) {
            result.add(p.val);
        }
        return result;
    }
}


    public static void bottomView(Node root) {
        if (root == null) return;

        // Map to store the bottom-most node at each horizontal distance
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        // Add root node with horizontal distance 0
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair current = q.poll();
            Node curr = current.node;
            int hd = current.hd;

            // Update the map with the current node's data at horizontal distance
            map.put(hd, curr.data);

            // Add left and right children with their respective horizontal distances
            if (curr.left != null) {
                q.add(new Pair(curr.left, hd - 1));
            }
            if (curr.right != null) {
                q.add(new Pair(curr.right, hd + 1));
            }
        }

        // Print the bottom view
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println("Bottom View:");
        bottomView(root);
    }
}
}
