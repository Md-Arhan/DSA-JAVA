package Tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Node;

public class GroupAnagrams {

    static class Node {
        Node children[];
        Boolean eow = false;
        List<String> list;

        Node() {
            children = new Node[26];
            list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String words, String sortedString) {  //O(L)
        Node curr = root;
        for (int i = 0; i < sortedString.length(); i++) {
            int idx = sortedString.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.list.add(words);
    }

    public static void dfs(Node root, List<List<String>> result) {
        Node curr = root;

        if (curr.list.isEmpty() == false) {
            result.add(curr.list);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                dfs(root.children[i], result);
            }
        }
    }

    public static void main(String[] args) {
        String strs[] = {"", "b" };

        //O(N * (llog(L) + O(l)) => O(N * Llog(l) + O(N*L)) => O(N * L log(l))
        for (int i = 0; i < strs.length; i++) {  //O(n)
            char ch[] = strs[i].toCharArray();
            Arrays.sort(ch);                     //O(Llog(n)), S = O(L)
            String sortedString = new String(ch);
            insert(strs[i], sortedString);       //O(L)
        }

        List<List<String>> result = new ArrayList<>();  // s = O(n*l)
        dfs(root, result);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}


/*
 * A static method cannot directly access a non-static (instance) variable because non-static variables belong to objects, and static methods do not belong to any object — they belong to the class itself.
 */


 /*
  * So What's Static and What's Not?
🧱 class Node — Non-static Inner Class:
Node is defined inside another class (assumed).

Since it's not marked static, it is a non-static inner class.

It means each instance of the outer class has its own version of Node.

You must create an instance of the outer class to create a Node.

✅ You’re using new Node() inside your outer class methods — that works because those methods are also non-static.

🌱 Node root = new Node(); — Instance Variable:
This is a non-static field of the outer class.

So again, you need an object of the outer class to access root.

🔧 insert, dfs, groupAnagrams — Non-static Methods:
These are not marked static, so they belong to an instance of the outer class.

They can access instance variables like root directly — which is why this works fine.

🤔 What If You Made These Methods static?
Suppose you did this:

public static void insert(String word, String original) { ... }
Then this line won’t compile:

Node curr = root;  // ❌ Cannot make a static reference to non-static field 'root'
Because:

root is non-static → it needs an object

insert is static → no object is assumed


  */




/*
 * When you call a non-static method, you're calling it on an object, so it already has access to that object's variables.
 */