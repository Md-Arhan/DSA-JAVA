public class PreOrderPostOrderCreate {
    class Solution {

        int i = 0;
        int j = 0;

        public Node dfs(int[] pre, int post[], int data) {

            if (data == post[j]) {
                return null;
            }

            Node root = new Node(pre[i++]);

            root.left = dfs(pre, post, root.data);
            root.right = dfs(pre, post, root.data);
            j++;

            return root;

        }

        public Node constructTree(int[] pre, int[] post) {
            // code here
            return dfs(pre, post, -1);
        }
    }
}


/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    int idx = 0;
    
    private Node dfs(int[] pre, int[] preMirror, int l, int r, HashMap<Integer, Integer> map){
        if(l > r){
            return null;
        }
        
        Node root = new Node(pre[idx++]);
        
        if(l == r){
            return root;
        }
        
        int nxtIdx = map.get(pre[idx]);
        
        root.left = dfs(pre, preMirror, nxtIdx, r, map);
        root.right = dfs(pre, preMirror, l+1, nxtIdx-1, map);
        
        return root;
    }
    
    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = preMirror.length;
        
        for(int i=0; i<n; i++){
            map.put(preMirror[i], i);
        }
        
        return dfs(pre, preMirror, 0, n-1, map);
    }
}