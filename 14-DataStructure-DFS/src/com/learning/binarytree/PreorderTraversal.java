package com.learning.binarytree;

import com.learning.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/4 22:08]
 */
public class PreorderTraversal {
	List<Integer> res = new ArrayList<Integer>();

	public List<Integer> preorderTraversal(TreeNode root) {
		traverse(root);
		return res;
	}

	/**
	 * 递归方法
	 *
	 * @param root 根
	 */
	public void traverse(TreeNode root) {
		if (root == null) return;
		res.add(root.val);
		traverse(root.left);
		traverse(root.right);
	}

	/**
	 * 前序遍历迭代方法
	 *
	 * @param root 根
	 * @return {@link List}<{@link Integer}>
	 */
	public List<Integer> preorderTraversalIterator(TreeNode root) {
		Stack<TreeNode> stack = new Stack();
		List<Integer> list = new LinkedList();
		TreeNode temp = root;
		while (!stack.isEmpty() || temp != null) {
			if (temp != null) {
				list.add(temp.val);
				stack.push(temp);
				temp = temp.left;
			} else {
				TreeNode node = stack.pop();
				temp = node.right;
			}
		}
		return list;
	}
}
