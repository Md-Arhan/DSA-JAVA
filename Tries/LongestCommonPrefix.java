package Tries;

public class LongestCommonPrefix {
    class Node {
        Node[] children;
        int freq;

        public Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 0;
        }
    }

    private final Node root = new Node();

    String ans = "";

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            curr.freq++;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    /*
     * 1:
     * "flow".startsWith("flower") → ❌ False
     * prefix = "flower".substring(0, 6-1) = "flowe"
     * "flow".startsWith("flowe") → ❌ False
     * prefix = "flow"
     * "flow".startsWith("flow") → ✅ True
     * ✅ After this iteration: prefix = "flow"
     * 
     * 2:
     * "flight".startsWith("flow") → ❌
     * prefix = "flo"
     * "flight".startsWith("flo") → ❌
     * prefix = "fl"
     * "flight".startsWith("fl") → ✅
     * ✅ After this iteration: prefix = "fl"
     */

    public void longest(Node root, int totalWords) {
        while (true) {
            int count = 0;
            int next = -1;
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null && root.children[i].freq == totalWords) {
                    count++;
                    next = i;
                }
            }

            if (count != 1)
                break; // only go deeper if exactly one child with full match

            ans += (char) (next + 'a');
            root = root.children[next];
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        for (int i = 0; i < strs.length; i++) {
            insert(strs[i]);
        }
        int totalwords = strs.length;
        longest(root, totalwords);
        return ans;
    }
}

/*
 * A longest common prefix must appear at the start of every string in the array
 * — no exceptions.
 * It’s like saying:
 * All strings must start the same way, up to a certain point.
 * As soon as one string differs → the prefix ends there.
 * 
 * Statement True?
 * Prefix must be at the start of every string ✅ Yes
 * Prefix can be anywhere in the string ❌ No
 * 
 */