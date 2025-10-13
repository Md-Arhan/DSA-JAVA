import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Leet Code 102

// public class practice_Session {

//     static class Node {
//         int data;
//         Node left;
//         Node right;

//         Node(int data) {
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }

//     public static <List<List<Integer>> levelOrder(Node root){
//         <List<List<Integer>> res = new ArrayList<>();
//         if (root == null) {
//             return res;
//         }

//         Queue<Node> q = new LinkedList<>();
//         q.add(root);

//         while (q.size()>0) {
//             int count = q.size();

//             List<Integer> row= new ArrayList<>();

//             for(int c=1; c<=count; count++){
//                 Node node = q.remove();
//                 row.add(node.data);

//                 if (root.left!=null) {
//                     q.add(root.left);
//                 }

//                 if (root.right != null) {
//                     q.add(root.right);
//                 }
//             }
//             res.add(row);
//         }
//     }

//     public static void main(String[] args) {
//         Node root = new Node(1);
//         root.left = new Node(2);
//         root.right = new Node(3);
//         root.left.left = new Node(4);
//         root.left.right = new Node(5);
//         root.right.left = new Node(6);
//         root.right.right = new Node(7);

//     }
// }

//Mirror Comparison

// public class practice_Session {
//     static class Node {
//         int data;
//         Node left;
//         Node right;

//         Node(int data) {
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }

//     public static Boolean mirrorComparison(Node root1, Node root2){

//         if (root1 == null && root2 == null) {
//             return true;
//         }

//         if (root1 == null || root2 == null) {
//             return false;
//         }

//         if (root1.data != root2.data) {
//             return false;
//         }

//         Boolean val1 = mirrorComparison(root1.left, root2.right);
//         if (val1 == false) {
//             return false;
//         }
//         Boolean val2 = mirrorComparison(root1.right, root2.left);

//         return val2;
//     }

//     public static boolean isSymmetric(Node root){
//         if (root == null) {
//             return true;
//         }

//         return mirrorComparison(root.left, root.right);
//     }

//     public static void main(String[] args) {
//         Node root = new Node(1);
//         root.left = new Node(2);
//         root.right = new Node(3);
//         root.left.left = new Node(4);
//         root.left.right = new Node(5);
//         root.right.left = new Node(6);
//         root.right.right = new Node(7);
//     }
// } 

//Construct Binary Tree  LC = 105

// public class practice_Session {

//     static class Node {
//         int data;
//         Node left;
//         Node right;

//         Node(int data) {
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }

//     static int idx = 0;

//     public static int search(int[] inOrder, int target) {
//         for (int i = 0; i < inOrder.length; i++) {
//             if (inOrder[i] == target) {
//                 return i;
//             }
//         }

//         return -1;
//     }

//     public static Node dfs(int[] preOrder, int[] inOrder, int l, int r) {
//         if (l > r) {
//             return null;
//         }
//         Node root = new Node(preOrder[idx++]);

//         int mid = search(inOrder, root.data);
//         root.left = dfs(preOrder, inOrder, l, mid - 1);
//         root.right = dfs(preOrder, inOrder, mid + 1, r);
//         return root;
//     }

//     public static void preOrder(Node root) {
//         if (root == null) {
//             // System.out.println(-1);
//             return;
//         }
//         System.out.print(root.data + " ");
//         preOrder(root.left);
//         preOrder(root.right);
//     }

//     public static void main(String[] args) {
//         int preOrder[] = { 3, 9, 20, 15, 7 };
//         int inOrder[] = { 9, 3, 15, 20, 7 };
//         int n = preOrder.length;
//         // dfs(preOrder, inOrder, 0, n - 1);
//         preOrder(dfs(preOrder, inOrder, 0, n - 1));

//     }
// }