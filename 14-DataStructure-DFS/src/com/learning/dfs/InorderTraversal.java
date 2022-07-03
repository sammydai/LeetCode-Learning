package com.learning.dfs;

import com.learning.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Package: com.learning.dfs
 * @Description: 94. Binary Tree Inorder Traversal 二叉树的中序遍历
 * @Author: Sammy
 * @Date: 2022/1/25 18:03
 */

public class InorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root==null) {
			return result;
		}
		helper(root,result);
		return result;
	}

	private static void helper(TreeNode treeNode, List<Integer> result) {
		if (treeNode == null) {
			return;
		}
		helper(treeNode.left,result);
		result.add(treeNode.val);
		helper(treeNode.right,result);
	}

	public List<Integer> inorderTraversalIterator(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			// 所有的左子树入栈
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			// 中序遍历：任何一个节点：左子树-根节点-右子树-访问，查看是否有右子树。
			// 没有右子树且栈内不为空，则继续出栈，访问栈顶元素
			cur = stack.pop();
			result.add(cur.val);
			cur = cur.right;
		}
		return result;
	}

	public List<Integer> inorderTraversalIterator2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			result.add(cur.val);
			cur = cur.right;
		}
		return result;
	}

}
