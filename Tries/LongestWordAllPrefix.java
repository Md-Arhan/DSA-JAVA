package Tries;

import java.sql.Blob;

//Longest Word with all Prefixes

public class LongestWordAllPrefix {

    static class Node {
        Node children[];
        Boolean eow = false;

        Node() {
            children = new Node[26];
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp){
       if (root == null) {
        return;
       }

       for(int i=25; i>=0; i++){
        if (root.children[i] != null && root.children[i].eow == true) {
            char ch = (char)(i+'a');
            temp.append(ch);
            if (temp.length() > ans.length()) {
                ans = temp.toString();
            }
            longestWord(root.children[i], temp);
            //backTrack
            temp.deleteCharAt(temp.length()-1);
        }
       }
    }

    public static void main(String[] args) {
        String words[] = {"a", "ap",  "banana", "app", "appl", "apply", "apple"};
        
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}

/*It's used to map letters to array indices */