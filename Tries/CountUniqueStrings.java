package Tries;

//Count Unique SubStrings
//suffix prefix question 

public class CountUniqueStrings {
 static class Node{
        Node children[];
        Boolean eow = false;

        Node(){
            children = new Node[26];
            for(int i=0; i<children.length; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        int level = 0;
        int len = word.length();
        int idx = 0;

        Node curr = root;
        for(; level<len; level++){
            idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static Boolean search(String key){
        int level = 0;
        int len = key.length();
        int idx = 0;

        Node curr = root;
        for(; level<len; level++){
            idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
               return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    public static int countNodes(Node root){
        if (root == null) {
            return 0;
        }

        int count = 0;
        for(int i=0; i<root.children.length; i++){
           if (root.children[i] != null) {
            count += countNodes(root.children[i]);
           }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        String str = "ababa";

        //Suffix -> insert in trie
        for(int i=0; i<str.length(); i++){
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(countNodes(root));
    }   
}


/*
 *  Trie Structure (simplified view):
Let’s build it step by step:

1. Insert "ababa"
Creates path: a → b → a → b → a

2. Insert "baba"
Adds: b → a → b → a
(because b doesn't exist at root)

3. Insert "aba"
This shares prefix with "ababa", so continues:
a → b → a already exists → no new nodes added

4. Insert "ba"
Follows from existing b → a (added in step 2)

5. Insert "a"
Just a already exists from "ababa"

✅ Count Trie Nodes:
Let’s count manually:

Root → 1 node

a → 1

b → 1

a → 1

b → 1

a → 1

b → 1 (new branch)

a → 1

b → 1

a → 1

Total Nodes:

1 (root)
+ 5 (a→b→a→b→a)
+ 4 (b→a→b→a)
= 10
✅ Output:

System.out.println(countNodes(root));
Returns 10

✅ Summary:
You inserted all suffixes.

Trie nodes represent all unique substrings.

countNodes() returns the total number of nodes.

So the number of unique substrings is:
countNodes(root) - 1 = 9

✅ Output printed: 10
✅ Number of unique substrings = 10 - 1 = 9
 */







 /*
  * Call: countNodes(a)
a is not null

Only a.children[1] (for 'b') is non-null

→ Recurse: countNodes(b)
Call: countNodes(b) (under a)
b is not null

Only b.children[2] (for 'c') is non-null

→ Recurse: countNodes(c)
Call: countNodes(c) (under b)
c is not null

All c.children[i] == null, so loop doesn't recurse

Returns 1 (just itself)

→ Back to b: count = 1 + 1 = 2
→ Back to a: count = 2 + 1 = 3

Now continue outer loop in countNodes(root):

i = 1 (child 'b' exists)
java
Copy
Edit
count += countNodes(root.children[1])
Call: countNodes(b) (root-level)
Has only c as child → recurse to countNodes(c)

→ countNodes(c) returns 1
→ countNodes(b) returns 1 + 1 = 2

→ Add 2 to main count: 3 + 2 = 5

i = 2 (child 'c' exists at root)
java
Copy
Edit
count += countNodes(root.children[2])
→ countNodes(c) → no children → returns 1
→ total = 5 + 1 = 6

Final Step:
Add 1 for the root node itself
→ Final answer = 6 + 1 = 7
  */
