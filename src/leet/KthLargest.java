package leet;

import java.util.Stack;


public class KthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int i = 0;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.right;
            } else {
                TreeNode node = stack.pop();
                i++;
                if (i == k) return node.val;
                cur = node.left;
            }
        }
        return -1;
    }

}
