public class HeightOfTree {
    static class Node {
        int data;
        Node left;
        Node right;
  
        Node(int data) {
           this.data = data;
           this.left = null;
           this.right = null;
        }
     }
  
     public static int height(Node root){
        if(root==null){
           return 0;
        }
  
        int lh = height(root.left);
        int rh = height(root.right);
        int height = Math.max(lh, rh) + 1;
  
        return height;
     }
  
     public static void main(String[] args) {
        /*
         *            1
         *          /   \
         *         2     3
         *        / \   /  \
         *       4   5 6   7
         */
  
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
  
        System.out.println(height(root));
     }
}


/* TIME COMPLEXITY
 * The height (or maximum depth) of a tree depends entirely on the tree's shape or type. Here's how it works:
 * 
🪜 Imagine a Ladder (Skewed Tree):
Think of a skewed tree like a ladder lying flat:

1 → 2 → 3 → 4 → 5
To find a number (say 5), you have to check every step — starting from 1, then 2, then 3… until you reach 5.

🔁 You might need to check all nodes one by one.

⏱️ That’s O(n) time — slow when the tree is big.



🌲 Imagine a Family Tree (Balanced Tree):
A balanced tree splits into branches like this:

        4
      /   \
     2     6
    / \   / \
   1   3 5   7
Now, to find 7, you:

Start at 4 → go right to 6 → go right to 7.

That’s just 3 steps, not 7.

✅ Even if the tree has 1,000 nodes, you only need around 10 steps.

⏱️ That’s O(log n) time — fast, like binary search.
 */



// SPACE COMPLEXITY

//DFS

/* DFS Space Complexity Depends on:
The maximum depth (or height) of the tree.

Because DFS uses a recursive call stack (or an explicit stack in iterative versions).

🌲 Balanced Tree
Example:

        4
      /   \
     2     6
    / \   / \
   1   3 5   7
Height = log(n) (since the tree is balanced).

DFS stack will at most hold log(n) calls at any one time.

✅ Space Complexity = O(log n)

For n Nodes:
Balanced tree height = log₂(n)
Max DFS stack size = path from root to leaf = log₂(n)


//Skew

🧱 Space Complexity:
The tree is skewed, so the recursive stack holds one call per node.

At the deepest level, the stack will have n recursive calls (because each node is being visited one-by-one).

The height of the tree is n - 1.

➡️ Space Complexity = O(n) for a skewed tree.

🪜 Skewed Tree (like a linked list)
Example:

markdown
Copy
Edit
1
 \
  2
   \
    3
     \
      4
Height = n - 1

DFS will go down one side all the way, stacking up n recursive calls.

❌ Space Complexity = O(n)

 */


//BFS

/*
 *  How BFS Works:
BFS explores the tree level by level:

It starts at the root and visits all the nodes on the first level (root), then moves to the next level, and so on.

BFS uses a queue to store the nodes at each level.

At each level:
Queue holds nodes of the current level.

As BFS progresses, the queue grows when it encounters more nodes at the next level.

🧱 Space Complexity Analysis:
In a balanced binary tree, each level doubles the number of nodes as you go down:

Level 0 (root): 1 node (just the root).

Level 1: 2 nodes.

Level 2: 4 nodes.

In general, level i has 2^i nodes.

Maximum Width:
The widest level is the bottommost level, where the number of nodes is maximized.

For this tree, the bottommost level (Level 2) has 4 nodes.

Queue Size at Worst:
The queue at the bottommost level will hold all the nodes at that level.

In this example, Level 2 has 4 nodes in the queue.

🔍 General Case for Balanced Trees:
The widest level (which determines the queue size) is always the last level.

For a balanced binary tree with n nodes, the maximum number of nodes at any level is approximately n / 2.

➡️ Space Complexity of BFS = O(n) in the worst case.

Space Complexity:
Max queue size = number of nodes at the last level = n / 2 (for complete binary trees)

So, Space Complexity = O(n) in the worst case

Exactly — in BFS, the amount of work and space per level typically increases as you move down the tree, not decreases.

BFS Space Complexity Recap:
For a complete or balanced binary tree, the maximum queue size in BFS is:

✅ Number of nodes at the last level, which is roughly n / 2

So:

Max queue size ≈ n / 2

Drop constants in Big-O → O(n)





//SKEW 

This is a right-skewed binary tree.

Each node has only one child.

Tree has n nodes, and height = n - 1.

Each level contains only one node.

🔁 How BFS Works:
BFS uses a queue and visits level by level. In this tree:

Level 0: 1

Level 1: 2

Level 2: 3

Level 3: 4

But in each level, there’s only 1 node.

📦 Queue Behavior in BFS:
Let’s dry-run BFS:

Start with queue: [1]

Visit 1, enqueue 2 → queue: [2]

Visit 2, enqueue 3 → queue: [3]

Visit 3, enqueue 4 → queue: [4]

Visit 4 → done

🔹 At every step, the queue has at most 1 node (the next node to visit).

✅ Space Complexity = O(1)
The queue never grows bigger than 1 node at any time.

So space complexity is constant.
 */