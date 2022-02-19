package com.learning.binarytree;

import com.learning.tree.TreeNode;
import com.sun.tools.corba.se.idl.constExpr.ShiftLeft;

/**
 * @Package: com.learning.binarytree
 * @Description: 98. Validate Binary Search Tree
 * @Author: Sammy
 * @Date: 2022/2/17 16:59
 */

public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

     public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
		if (root == null) {
			return true;
		}
		if (root.val>=maxVal||root.val<=minVal) {
			 return false;
		}
		 return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	 }
}
