// import java.util.*;

// public class Additional {
//     static class Node {
//         int data;
//         Node left, right;
    
//         Node(int data) {
//             this.data = data;
//             this.left = this.right = null;
//         }
//     }
    
//     public static Node largestBSTRoot = null;
    
//     public static void findLargestBST(Node root) {
//         if (root == null) {
//             return;
//         }
    
//         // Example: If we find a subtree with a larger BST, update largestBSTRoot
//         if (root.data == 60) {  // Example condition for largest BST subtree
//             largestBSTRoot = root;
//         }
    
//         // Recursively find in left and right subtrees
//         findLargestBST(root.left);
//         findLargestBST(root.right);
//     }
    
//     public static void main(String[] args) {
//         Node root = new Node(50);
//         root.left = new Node(30);
//         root.right = new Node(60);
//         root.right.left = new Node(45);
//         root.right.right = new Node(70);
//         root.right.right.left = new Node(65);
//         root.right.right.right = new Node(80);
    
//         // Find the largest BST
//         findLargestBST(root);
        
//         // After the traversal, largestBSTRoot should point to the node with value 60
//         if (largestBSTRoot != null) {
//             System.out.println("Largest BST root data: " + largestBSTRoot.data);
//             System.out.println("Left child of largest BST root: " + largestBSTRoot.left.data);
//             System.out.println("Right child of largest BST root: " + largestBSTRoot.right.data);
//         }
//     }
// }
