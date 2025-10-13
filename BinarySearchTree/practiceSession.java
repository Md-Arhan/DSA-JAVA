// import javax.swing.tree.TreeNode;


//practice Session 1


// public class practiceSession {

//     // * Definition for a binary tree node.
//     public class TreeNode {
//         int val;
//         TreeNode left;
//         TreeNode right;

//         TreeNode() {
//         }

//         TreeNode(int val) {
//             this.val = val;
//         }

//         TreeNode(int val, TreeNode left, TreeNode right) {
//             this.val = val;
//             this.left = left;
//             this.right = right;
//         }
//     }

//     class Solution {
//         public TreeNode deleteNode(TreeNode root, int key) {
//             if (root == null) {
//                 return null;
//             }

//             if (key < root.val) {
//                 root.left = deleteNode(root.left, key);
//                 return root;
//             }

//             else if (key > root.val) {
//                 root.right = deleteNode(root.right, key);
//                 return root;
//             }

//             else {
//                 if (root.left == null) {
//                     return root.right;
//                 } else if (root.right == null) {
//                     return root.left;
//                 } else {
//                     TreeNode temp = root.right;
//                     temp = inorderSuccessor(temp);

//                     root.val = temp.val;
//                     root.right = deleteNode(root.right, temp.val);
//                     return root;
//                 }
//             }
//         }

//         TreeNode inorderSuccessor(TreeNode temp) {
//             while (temp.left != null) {
//                 temp = temp.left;
//             }
//             return temp;
//         }
//     }

// }




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public TreeNode searchBST(TreeNode root, int key) {
//         if(root == null) {
//             return root;
//         }
//         else if(root.val == key){
//             return root;
//         }
//         else if(key<root.val) {
//             return searchBST(root.left,val);
//         }
//         else {
//             return searchBST(root.right,val);
//         }
//     }
// }


// import java.util.*;
 
// class InsertBst {
 
//     static class Node {
//         int key;
//         Node left, right;
//         int freq;
 
//         public Node(int item)
//         {
//             key = item;
//             left = right = null;
//         }
//     }
 
//     static Node insert(Node root, int key)
//     {
 
//         if (root == null)
//             return new Node(key);
 
//         if (root.key == key)
//             return root;
 
//         if (key < root.key)
//             root.left = insert(root.left, key);
//         else
//             root.right = insert(root.right, key);
 
//         return root;
//     }
 
//     static void inorder(Node root)
//     {
//         if (root != null) {
//             inorder(root.left);
//             System.out.print(root.key + " ");
//             inorder(root.right);
//         }
//     }
 
//     public static void main(String[] args)
//     {
//         Node root = null;
 
//         root = insert(root, 50);
//         root = insert(root, 30);
//         root = insert(root, 20);
//         root = insert(root, 40);
//         root = insert(root, 70);
//         root = insert(root, 60);
//         root = insert(root, 80);
 
//         inorder(root);
//     }
// }


//practice Session 2nd


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         if (root == null) {
//             return 0;
//         }
//         if (root.val < low) {
//             return rangeSumBST(root.right, low, high); 
//         }
//         if (root.val > high) {
//             return rangeSumBST(root.left, low, high);
//         }
//         return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
//     }
// }




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     int ans = Integer.MAX_VALUE;
//     int prev = -1;
 
//     public int getMinimumDifference(TreeNode root) {
//         if (root == null) return ans;
 
//         getMinimumDifference(root.left);
 
//         if (prev != -1) {
//             ans = Math.min(ans, root.val - prev);
//         }
//         prev = root.val;
 
//         getMinimumDifference(root.right);
 
//         return ans;
//     }
// }






/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }
 
//     public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
//         if (root == null) { 
//             return true;
//         }
//         if (root.val >= maxVal || root.val <= minVal) {
//             return false;
//         }
 
//         boolean isLeftValid = isValidBST(root.left, minVal, root.val);
//         boolean isRightVaild = isValidBST(root.right, root.val, maxVal);
//         return isLeftValid && isRightVaild;
//     }
// }




// import java.util.*;
 
// class MaximumSumBST {
//     static class Node 
//     {
//         Node left;
//         Node right;
//         int data;
 
//         Node(int data)
//         {
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }
 
//     static class Info 
//     {
//         int max;
//         int min;
//         boolean isBST;
//         int sum;
//         int currmax;
 
//         Info(int max,int min,boolean isBST,int sum,int currmax)
//         {
//             this.max = max;
//             this.min = min;
//             this.isBST = isBST;
//             this.sum = sum;
//             this.currmax = currmax;
//         }
 
//         Info() {
//             this.max = 0;
//             this.min = 0;
//             this.isBST = true;
//             this.sum = 0;
//             this.currmax = 0;
//         }
//     }
 
//     static int maxsum;
 
//     static Info MaxSumBSTUtil( Node root)
//     {
//         if (root == null)
//             return new Info( Integer.MIN_VALUE, 
//                             Integer.MAX_VALUE, true, 0, 0 );
 
//         if (root.left == null && root.right == null)
//         {
//             maxsum = Math.max(maxsum, root.data);
//             return new Info( root.data, root.data, 
//                             true, root.data, maxsum);
//         }
 
//         // Store information about the left subtree
//         Info L = MaxSumBSTUtil(root.left);
 
//         // Store information about the right subtree
//         Info R = MaxSumBSTUtil(root.right);
 
//         Info BST=new Info();
 
//         // If the subtree rooted under the current node
//         // is a BST
//         if (L.isBST && R.isBST && L.max < root.data && 
//                                 R.min > root.data)
//         {
 
//             BST.max = Math.max(root.data, Math.max(L.max, R.max));
//             BST.min = Math.min(root.data, Math.min(L.min, R.min));
 
//             maxsum = Math.max(maxsum, R.sum + root.data + L.sum);
//             BST.sum = R.sum + root.data + L.sum;
 
//             // Update the current maximum sum
//             BST.currmax = maxsum;
 
//             BST.isBST = true;
//             return BST;
//         }
 
//         // If the whole tree is not a BST then
//         // update the current maximum sum
//         BST.isBST = false;
//         BST.currmax = maxsum;
//         BST.sum = R.sum + root.data + L.sum;
 
//         return BST;
//     }
 
//     static int MaxSumBST( Node root)
//     {
//         maxsum = Integer.MIN_VALUE;
//         return MaxSumBSTUtil(root).currmax;
//     }
 
//     public static void main(String args[])
//     {
//         Node root = new Node(5);
//         root.left = new Node(14);
//         root.right = new Node(3);
//         root.left.left = new Node(6);
//         root.right.right = new Node(7);
//         root.left.left.left = new Node(9);
//         root.left.left.right = new Node(1);
 
//         System.out.println( MaxSumBST(root));
//     }
// }