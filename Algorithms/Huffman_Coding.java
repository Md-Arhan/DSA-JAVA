package Algorithms;

import java.util.ArrayList;

public class Huffman_Coding {
    class Solution {

        ArrayList<String> ans;

        class Node implements Comparable<Node> {
            int freq;
            int idx;
            Node left;
            Node right;

            Node(int freq, int idx) {
                this.freq = freq;
                this.idx = idx;
                this.left = null;
                this.right = null;
            }

            @Override
            public int compareTo(Node other) {
                if (this.freq == other.freq) {
                    return this.idx - other.idx;
                }
                return this.freq - other.freq;
            }
        }

        public void dfs(Node root, String temp) {
            if (root == null)
                return;

            if (root.left == null && root.right == null) {
                ans.add(temp);
                return;
            }

            dfs(root.left, temp + "0");
            dfs(root.right, temp + "1");
        }

        public ArrayList<String> huffmanCodes(String s, int f[]) {
            // Code here
            PriorityQueue<Node> pq = new PriorityQueue<>();
            ans = new ArrayList<>();

            if (f.length == 1) {
                ans.add("0");
                return ans;
            }

            for (int i = 0; i < f.length; i++) {
                pq.add(new Node(f[i], i));
            }

            while (pq.size() > 1) {
                Node one = pq.poll();
                Node two = pq.poll();

                Node newNode = new Node(one.freq + two.freq, Math.min(one.idx, two.idx));
                newNode.left = one;
                newNode.right = two;

                pq.add(newNode);
            }

            Node root = pq.poll();
            dfs(root, "");

            return ans;
        }
    }
}
