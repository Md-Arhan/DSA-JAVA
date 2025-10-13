public class FindMode {
    class Solution {

    Integer prev = null;
    int count = 0;
    int maxCount = 0;
    List<Integer> ans = new ArrayList<>();

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);

        if(prev!= null && prev == root.val){
            count++;
        }else{
            count = 1;
        }

        if(count > maxCount){
            maxCount = count;
            ans.clear();
            ans.add(root.val);
        }else if(count == maxCount){
            ans.add(root.val);
        }

        prev = root.val;
        inorder(root.right);
    }
    
    public int[] findMode(TreeNode root) {
        inorder(root);
        
        int res[] = new int[ans.size()];

        for(int i = 0; i<ans.size(); i++){
            res[i] = ans.get(i);
        }

        return res;
    }
}
}


/*
 * 🔍 Step-by-Step Dry Run:
Start with:

prev = null, count = 0, maxCount = 0, ans = []

Now traverse in-order:

Visit 2:

prev == null → count = 1

count > maxCount (0) → update maxCount = 1, clear ans, add 2

ans = [2], prev = 2

Visit 2 again:

prev == 2 → count = 2

count > maxCount (1) → update maxCount = 2, clear ans, add 2

ans = [2], prev = 2

Visit 3:

prev = 2, different → count = 1

count < maxCount → skip

ans = [2], prev = 3

Visit 3 again:

prev = 3 → count = 2

count == maxCount (2) → add 3 to ans

ans = [2, 3], prev = 3

Visit 5:

count = 1 (new value)

count < maxCount → skip

ans = [2, 3], prev = 5

Visit 6:

Same logic → skip

ans = [2, 3]

Visit 7:

Same → skip

Visit 8:

Same → skip

✅ Final Output:
maxCount = 2

ans = [2, 3]

Returned array: [2, 3]

 */