// Java code to find the bottom view 
// using level-order traversal
// import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

public class Additional {

    // Function to return the bottom view
      // of the binary tree
    static ArrayList<Integer> bottomView(Node root) {
      
        if (root == null) return new ArrayList<>();

        // Map to store the last node at each 
        // horizontal distance (HD)
        Map<Integer, Integer> hdMap = new TreeMaps<>();

        // Queue to store nodes and their 
        // horizontal distance
        Queue<Pair> q = new LinkedList<>();
        
        // Start level order traversal with
          // root at HD 0
        q.add(new Pair(root, 0));
        
        while (!q.isEmpty()) {
          
            // Get current node and its HD
            Node curr = q.peek().node;
            int hd = q.peek().hd;
            q.poll();

            // Update the map with the current
              // node's data
            hdMap.put(hd, curr.data);

            // Traverse the left subtree, HD - 1
            if (curr.left != null) {
                q.add(new Pair(curr.left, hd - 1));
            }

            // Traverse the right subtree, HD + 1
            if (curr.right != null) {
                q.add(new Pair(curr.right, hd + 1));
            }
        }

        // Extract bottom view nodes 
          // from the map
        ArrayList<Integer> result = new ArrayList<>();
        
        // Iterate through the map in 
          // sorted HD order
        for (int value : hdMap.values()) {
            result.add(value);
        }
        
        return result;
    }

    public static void main(String[] args) {
      
        // Representation of the input tree:
        //       20
        //      /  \
        //     8   22
        //    / \    \
        //   5   3   25
        //      / \
        //     10 14
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

        ArrayList<Integer> result = bottomView(root);

        for (int val : result) {
          System.out.print(val + " ");
      } 
    }
}


//kth Level of a tree 

// import java.util.*;

// class TreeNode {
//     int val;
//     TreeNode left, right;

//     TreeNode(int val) {
//         this.val = val;
//         this.left = this.right = null;
//     }
// }

// public class Additional {

//     public static List<Integer> getKthLevelNodes(TreeNode root, int k) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null || k < 0) return result; // Handle edge cases
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         int level = 0;

//         while (!queue.isEmpty()) {
//             int size = queue.size(); // Number of nodes at the current level
            
//             // Check if we have reached the Kth level
//             if (level == k) {
//                 for (int i = 0; i < size; i++) {
//                     TreeNode node = queue.poll();
//                     result.add(node.val); // Collect node values at Kth level
//                 }
//                 break;
//             }
            
//             // Process nodes at the current level and enqueue children
//             for (int i = 0; i < size; i++) {
//                 TreeNode node = queue.poll();
//                 if (node.left != null) queue.add(node.left);
//                 if (node.right != null) queue.add(node.right);
//             }
            
//             level++; // Move to the next level
//         }

//         return result;
//     }

//     public static void main(String[] args) {
//         // Example tree
//         TreeNode root = new TreeNode(1);
//         root.left = new TreeNode(2);
//         root.right = new TreeNode(3);
//         root.left.left = new TreeNode(4);
//         root.left.right = new TreeNode(5);
//         root.right.left = new TreeNode(6);
//         root.right.right = new TreeNode(7);

//         int k = 2; // Level to fetch
//         List<Integer> nodesAtKthLevel = getKthLevelNodes(root, k);
//         System.out.println("Nodes at level " + k + ": " + nodesAtKthLevel);
//     }
// }



