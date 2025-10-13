package Tries;


//Prefix Problem
/* Find shortest unique Prefix for every word in a given list.
 * Assume no word is prefix of another
 */

public class Prefix {
    static class Node {
    Node children[];
    Boolean erow = false;
    int freq;

    Node() {
      children = new Node[26];
      for (int i = 0; i < children.length; i++) {
        children[i] = null;
        freq = 1;
      }
    }
  }

  public static Node root = new Node();

  public static void insert(String word) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';
      if (curr.children[idx] == null) {
        curr.children[idx] = new Node();
        // curr.freq = 1;
      } else {
        curr.children[idx].freq++;
      }
      curr = curr.children[idx];
    }

    curr.erow = true;
  }

  public static void findPrefix(Node root, String ans) {  //O(L) : Levels in my trie, longest trie
    if (root == null) {
      return;
    }

    if (root.freq == 1) {
      System.out.println(ans);
      return;
    }

    for (int i = 0; i < root.children.length; i++) {
      if (root.children[i] != null) {
        findPrefix(root.children[i], ans + (char) (i + 'a'));
      }
    }

  }

  public static void main(String[] args) {
    String arr[] = { "zebra", "dog", "duck", "dove" };
    for (int i = 0; i < arr.length; i++) {
      insert(arr[i]);
    }

    root.freq = -1;
    findPrefix(root, "");
  }
}
