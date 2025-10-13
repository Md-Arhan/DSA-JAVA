package Tries;

public class Insertion {
    static class Node{
        Node[] children;
        Boolean eow = false;

        Node(){
          children = new Node[26];
          for(int i=0; i<children.length; i++){
            children[i] = null;
          }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){   //O(L)
      Node curr = root;
      for(int level = 0; level<word.length(); level++){
        int idx = word.charAt(level) - 'a';
        if (curr.children[idx] == null) {
          curr.children[idx] = new Node();
        }
        curr = curr.children[idx];
      }

      curr.eow = true;

    }

    public static Boolean search(String key){  //O(L)
      Node curr = root;
      for(int level = 0; level<key.length(); level++){
        int idx = key.charAt(level) - 'a';
        if (curr.children[idx] == null) {
          return false;
        }
        curr = curr.children[idx];
      }

      return curr.eow == true;
    }

    public static void main(String []args){
      String words[] = {"the", "a", "there", "their", "any", "thee"};
      for(int i=0; i<words.length; i++){
         insert(words[i]);
      }

      System.out.println(search("thee"));
      System.out.println(search("thor"));

    }
}



/*
 * 
 * | Feature                     | `Trie[] children` ❌                 | `Node[] children` ✅                |
| --------------------------- | ----------------------------------- | ---------------------------------- |
| Each child is a             | Full `Trie` object                  | Lightweight `Node` object          |
| Contains insert/search/etc? | Yes (in every node) ❌               | No, only the main class has them ✅ |
| Has its own root?           | Yes (due to `static Trie root`) ❌   | No                                 |
| Memory usage                | High (methods & static per node) ❌  | Low (just data) ✅                  |
| OOP structure               | Confusing (self-referencing tree) ❌ | Clean separation (Trie vs Node) ✅  |




It has its own children[]

It has its own eow

It also has a static root inside it again (due to public static Trie root = new Trie()), leading to a recursive mess.
 */


 /*
  * You're creating a whole new instance of the Trie class, which includes:

All the methods (insert(), search(), startsWith())

The static root field

The full logic and structure meant only for the main tree

⚠️ Why This Can Cause Issues (Sometimes)
Yes, not always — but it does cause subtle bugs and inefficiencies:

✅ Works sometimes:
Because you're not calling insert() on a child node, the duplicate logic isn't actively misused.

So it behaves mostly like a node.

| Situation                           | Problem                                                                                   |
| ----------------------------------- | ----------------------------------------------------------------------------------------- |
| Static root in multiple nodes       | Shared state across all instances (not per tree)                                          |
| Unexpected behavior in `startsWith` | Because logic may rely on global `root`, not local nodes                                  |
| Memory overhead                     | You're storing unnecessary methods and statics in every node                              |
| Code readability                    | Confusing structure; looks like each letter has its own tree                              |
| Extensibility                       | If you later add features (like delete, depth, frequency count), it gets harder to manage |


Each node is lightweight: only children[] + eow

All logic stays in the Trie class, so you don’t duplicate methods

No static confusion

Clean, fast, extensible
  */


/*
 * ✅ Each node:
Is lightweight: it only stores data (children[], eow)
Doesn't know how to insert or search — that logic is only in the main Trie class

✅ Benefits:
👌 Efficient: No extra memory for methods or static fields
🔐 Encapsulated: Logic stays in one place
🧠 Clear structure: Trie controls the structure, Node holds the data
💡 Flexible: You can add more fields to Node (e.g., frequency counter, value, etc.) without touching logic
 */



/*
Each time you're adding a new node, you’re actually creating a whole new Trie object, which means:
It includes children[]
It includes eow
It includes the methods insert(), search(), startsWith()
⚠️ It includes the static root — but only one exists per class, so it's shared and can be accidentally misused

💥 Consequences
You're duplicating logic and structure in every node.
Wasting memory — each node is heavier than needed.
Logical confusion — child "nodes" should only contain structure, not full Trie functionality.
Harder to debug and extend.
*/