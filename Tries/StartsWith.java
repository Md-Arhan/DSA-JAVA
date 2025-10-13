package Tries;

public class StartsWith {
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

  public static void insert(String word) { // O(L)
    Node curr = root;
    for (int level = 0; level < word.length(); level++) {
      int idx = word.charAt(level) - 'a';
      if (curr.children[idx] == null) {
        curr.children[idx] = new Node();
      }
      curr = curr.children[idx];
    }

    curr.eow = true;

  }

  public static Boolean startsWith(String key) { // O(L)
    Node curr = root;
    for (int level = 0; level < key.length(); level++) {
      int idx = key.charAt(level) - 'a';
      if (curr.children[idx] == null) {
        return false;
      }
      curr = curr.children[idx];
    }

    return true;
  }

  public static void main(String[] args) {
    String words[] = { "apple", "app", "amngo", "man", "woman" };
    for (int i = 0; i < words.length; i++) {
      insert(words[i]);
    }

    String prefix = "app";
    String prefix1 = "moon";
    System.out.println(startsWith(prefix));
    System.out.println(startsWith(prefix1));
  }
}
