x   class Solution {

    public int solve(TreeNode root, int curr){
        if(root == null){
            return 0;
        }

        curr = curr * 2 + root.val;

        if(root.left == null && root.right == null){
            return curr;
        }

        return solve(root.left, curr) + solve(root.right, curr);

    }

    public int sumRootToLeaf(TreeNode root) {
        return solve(root, 0);
    }
}


/*
Each root-to-leaf path forms a binary number.

While traversing the tree:

curr = curr * 2 + root.val;

✔ curr * 2 → shift bits left (make space)
✔ + root.val → append current bit (0 or 1)

When reaching a leaf:

✔ Binary number complete → return curr

Final answer:

✔ Sum of all root-to-leaf binary numbers
*/