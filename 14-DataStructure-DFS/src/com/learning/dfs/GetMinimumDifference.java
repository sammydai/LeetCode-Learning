package com.learning.dfs;

/**
 * 530. Minimum Absolute Difference in BST
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/30 21:49]
 */
public class GetMinimumDifference {
	int pre;
	int ans;

	public int minDiffInBST(TreeNode root) {
		ans = Integer.MAX_VALUE;
		pre = -1;
		dfs(root);
		return ans;
	}

	public void dfs(TreeNode root) {
		if (root == null) return;
		dfs(root.left);
		if (pre == -1) {
			pre = root.val;
		} else {
			ans = Math.min(ans, root.val - pre);
			pre = root.val;
		}
		dfs(root.right);
	}
}
