/* The Node structure is defined as
class Node {
	int data;
	Node left;
	Node right;
	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
*/

class Solution {
	public int absDiff(Node root) {
		// code here
		
		List<Integer>trav = new ArrayList<>();
		
		int[]ans = new int[1];
		int prev = Integer.MAX_VALUE;
		ans[0] = Integer.MAX_VALUE;
		preOrder(root, prev, ans);
		return ans[0];
	}
	
	public int preOrder(Node root, int prev, int[]ans)
	{
		
		if (root == null)
			return prev;
		
		prev = preOrder(root.left, prev, ans);
		if (prev != Integer.MAX_VALUE)
			{
			ans[0] = Math.min(ans[0], root.data - prev);
		}
		prev = root.data;
		prev = preOrder(root.right, prev, ans);
		
		return prev;
		
	}
}
