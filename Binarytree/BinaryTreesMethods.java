import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class BinaryTreesMethods {
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

   static class BinaryTree {
      static int idx = -1;

      public static Node buildTree(int nodes[]) {
         idx++;
         if (nodes[idx] == -1) {
            return null;
         }

         Node newNode = new Node(nodes[idx]);
         newNode.left = buildTree(nodes);
         newNode.right = buildTree(nodes);

         return newNode;
      }

      public static void preOrder(Node root) {  // O(n)
         if (root == null) {
            // System.out.println(-1);
            return;
         }
         System.out.print(root.data + " ");
         preOrder(root.left);
         preOrder(root.right);
      }

      public static void inOrder(Node root) {  //O(n)
         if (root == null) {
            return;
         }
         inOrder(root.left);
         System.out.print(root.data + " ");
         inOrder(root.right);
      }

      public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
         Deque<TreeNode> stack = new ArrayDeque<>();
     
         while (root != null || !stack.isEmpty()) {
           while (root != null) {
             stack.push(root);
             root = root.left;
           }
           root = stack.pop();
           ans.add(root.val);
           root = root.right;
         }
     
         return ans;
       }

      public static void postOrder(Node root) {  //O(n)
         if (root == null) {
            return;
         }
         postOrder(root.left);
         postOrder(root.right);
         System.out.print(root.data + " ");
      }

      //Level Order Traversal
      public static void levelOrder(Node root){
         if (root == null) {
            return;
         }

         Queue<Node> q = new LinkedList<>();
         q.add(root);
         q.add(null);

         while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
               System.out.println();
               if (q.isEmpty()) {
                  break;
               }else{
                  q.add(null);
               }
            }else{
               System.out.print(curr.data + " ");
               if (curr.left != null) {
                  q.add(curr.left);
               }
               if (curr.right != null) {
                  q.add(curr.right);
               }
            }
         }
      }
   }

   public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        // If root is null, return empty list
        if (root == null) {
            return ans;
        }

        // Start with the root node and add a null as a level separator
        q.add(root);
        q.add(null); // level separator

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            // If the current node is null, it's a level separator
            if (curr == null) {
                if (!q.isEmpty()) { // If the queue is not empty, it means there are more levels
                    q.add(null); // Add the null to mark the next level
                    ans.add(new ArrayList<>(temp)); // Add the current level to ans
                    temp = new ArrayList<>(); // Reset temp for the next level
                }
            } else {
                // Add current node's value to temp
                temp.add(curr.val);

                // Add left and right children to the queue
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        if(!temp.isEmpty()){
            ans.add(new ArrayList<>(temp));
        }

        return ans;
    }

   public static void main(String[] args) {
      int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
      BinaryTree tree = new BinaryTree();
      Node root = tree.buildTree(nodes); // -> O(n)
      // System.out.println(root.data);

      // preOrder Traversal -> O(n)
      // tree.preOrder(root);

      // inOreder Traversal
      // tree.inOrder(root);

      // postOrder Traversal
      // tree.postOrder(root);

      //Level Order Traversal
      //tree.levelOrder(root);
   }
}
