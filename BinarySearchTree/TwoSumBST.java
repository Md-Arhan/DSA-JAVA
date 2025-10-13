import java.util.ArrayList;
import java.util.Stack;

public class TwoSumBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int count = 0;

    public static void inOrder(Node root, ArrayList<Integer> list){
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    // Function to count pairs from two BSTs with sum equal to x using Stack
    static int countPairs(Node root1, Node root2, int x) {
        if (root1 == null || root2 == null) return 0;

        Stack<Node> st1 = new Stack<>(); // Stack for ascending order traversal (BST1)
        Stack<Node> st2 = new Stack<>(); // Stack for descending order traversal (BST2)

        Node top1, top2;
        int count = 0;

        // Iterate until either stack is empty
        while (true) {
            // Push all left nodes of root1 into st1
            while (root1 != null) {
                st1.push(root1);
                root1 = root1.left;
            }

            // Push all right nodes of root2 into st2
            while (root2 != null) {
                st2.push(root2);
                root2 = root2.right;
            }

            // If either stack is empty, we are done
            if (st1.isEmpty() || st2.isEmpty()) break;

            // Peek the top nodes from both stacks
            top1 = st1.peek();
            top2 = st2.peek();

            // Check the sum of the two nodes
            if ((top1.data + top2.data) == x) {
                // A valid pair is found
                count++;
                // Move to the next nodes in both BSTs
                st1.pop();
                st2.pop();
                root1 = top1.right;
                root2 = top2.left;
            } else if ((top1.data + top2.data) < x) {
                // Move to the next larger value in BST1
                st1.pop();
                root1 = top1.right;
            } else {
                // Move to the next smaller value in BST2
                st2.pop();
                root2 = top2.left;
            }
        }

        return count;
    }

    public static void twoSumBSTs(ArrayList<Integer> list1, ArrayList<Integer> list2, int x){
        int i=0, j=list2.size()-1;

        while (i<list1.size() && j>=0 ) {
            int curr = list1.get(i) + list2.get(j);
            if (curr == x) {
                System.out.println("(" + list1.get(i) + "," + list2.get(j) + ")");
                count++;
                i++;
                j--;
            }else if (curr < x) {
                i++;
            }else{
                j--;
            }
        }
    }

    public static void main(String args[]){
        // Construct BST1
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        // Construct BST2
        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        inOrder(root1, list1);
        inOrder(root2, list2);

        twoSumBSTs(list1, list2, 16);
        System.out.println(count);

    }
}
