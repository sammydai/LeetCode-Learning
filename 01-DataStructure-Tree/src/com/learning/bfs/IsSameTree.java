package com.learning.bfs;

import com.learning.tree.TreeNode;

/**
 * @Package: com.learning.bfs
 * @Description: 100. Same Tree
 * @Author: Sammy
 * @Date: 2022/1/26 22:46
 */

public class IsSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return inorderTraversal(p, q);
    }

	private boolean inorderTraversal(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		return inorderTraversal(p.left, q.left) && inorderTraversal(p.right, q.right);
	}
}
