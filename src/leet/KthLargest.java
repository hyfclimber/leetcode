package leet;

import java.util.Stack;

//剑指 Offer 54. 二叉搜索树的第k大节点
//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。

public class KthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//递归法。实践复杂度:O(N) 空间复杂度: O(N)
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
//	递归法
	public int kthLargest1(TreeNode root, int k) {
		dfs(root, k);
		return ans;
    }
	static int i = 0;
	static int ans = -1;
	public static void dfs(TreeNode node, int k) {
		if (node.right != null) {
			dfs(node.right, k);
		}
		i++;
		if (i == k) {
			ans = node.val;
			return;
		}
		if (node.left != null) {
			dfs(node.left, k);
		}
	}

}
