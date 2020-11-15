package com.learning.binarytree;

import com.learning.tree.TreeNode;

/**
 * @Package: com.learning.binarytree
 * @Description: 110. Balanced Binary Tree
 * @Author: Sammy
 * @Date: 2020/11/15 23:15
 */

public class BalancedTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(getDepth(root.right)-getDepth(root.left))>1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
    }

	public static int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getDepth(root.left), getDepth(root.right));
	}


}
