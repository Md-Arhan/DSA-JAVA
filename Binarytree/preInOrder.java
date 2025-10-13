import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class preInOrder {
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void findMid(int[] inorder, int start, int end){
        if(start > end){
            ans.add(-1);
            return;
        }

        int mid = start + (end - start) / 2;
        ans.add(inorder[mid]);

        findMid(inorder, start, mid-1);
        findMid(inorder, mid+1, end);

    }


    public static void preIn(int[] preOrder, int[] inOrder) {
        int target = preOrder[0];
        int mid = 0;
        int start = 0;
        int end = inOrder.length-1;

        for(int i=0; i<inOrder.length; i++){
            if(inOrder[i] == target){
                mid = i;
                break;
            }
        }

        System.out.println(inOrder[mid]);

        ans.add(inOrder[mid]);

        findMid(inOrder, start, mid-1);
        findMid(inOrder, mid+1, end);
    }

     public int find(int inorder[], int target){
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == target){
                return i;
            }
        }

        return -1;
    }

    int idx = 0;

    public TreeNode dfs(int[] preorder, int[] inorder, int l, int r){

        if(l>r){
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx++]);

        int mid = find(inorder, root.val);

        root.left = dfs(preorder, inorder, l, mid-1);
        root.right = dfs(preorder, inorder, mid+1, r);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        preIn(preorder, inorder);
        
        for(int i=0; i<ans.size(); i++){
         System.out.print(ans.get(i) + " ");
        }
    }
}
