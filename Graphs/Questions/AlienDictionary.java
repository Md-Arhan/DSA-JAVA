package Questions;

import java.util.*;

public class AlienDictionary {

  static String alienDictionary(List<String> words) {
    HashMap<Character, Integer> indegree = new HashMap<>();
    HashMap<Character, ArrayList<Character>> adj = new HashMap<>();
    int n = words.size();

    for (char ch = 'a'; ch <= 'z'; ch++) {
      adj.put(ch, new ArrayList<>());
      indegree.put(ch, 0);
    }

    for (int i = 0; i < n - 1; i++) {
      String s1 = words.get(i);
      String s2 = words.get(i + 1);

      for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
        char ch1 = s1.charAt(j);
        char ch2 = s2.charAt(j);

        if (ch1 != ch2) {
          adj.get(ch1).add(ch2);
          indegree.put(ch2, indegree.get(ch2) + 1);
        }
      }
    }

    Queue<Character> q = new LinkedList<>();

    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (indegree.get(ch) == 0) {
        q.add(ch);
      }
    }

    String ans = "";

    while (!q.isEmpty()) {
      char ch = q.remove();
      ans += ch;

      for (char conn : adj.get(ch)) {
        indegree.put(conn, indegree.get(conn) - 1);

        if (indegree.get(conn) == 0) {
          q.add(conn);
        }
      }
    }

    return ans;

  }

  public static void main(String[] args) {

  }
}
