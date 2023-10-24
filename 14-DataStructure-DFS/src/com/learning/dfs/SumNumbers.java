package com.learning.dfs;

import com.learning.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 129. Sum Root to Leaf Numbers
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/24 09:50]
 */
public class SumNumbers {
	int result = 0;

	public int sumNumbersNew(TreeNode root) {
		if (root != null) {
			dfs(root, 0);
		}
		return result;
	}

	public void dfs(TreeNode node, int number) {
		number = number * 10 + node.val;
		if (node.left == null && node.right == null) {
			result += number;
			return;
		}
		if (node.left != null) {
			dfs(node.left, number);
		}
		if (node.right != null) {
			dfs(node.right, number);
		}
	}

	public int sumNumbers(TreeNode root) {
		if (root == null) return 0;
		int sum = 0;
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		Queue<Integer> numQueue = new LinkedList<Integer>();
		nodeQueue.offer(root);
		numQueue.offer(root.val);
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.poll();
			int num = numQueue.poll();
			TreeNode left = node.left;
			TreeNode right = node.right;
			if (left == null && right == null) {
				sum += num;
			} else {
				if (left != null) {
					nodeQueue.offer(left);
					numQueue.offer(num * 10 + left.val);
				}
				if (right != null) {
					nodeQueue.offer(right);
					numQueue.offer(num * 10 + right.val);
				}
			}
		}
		return sum;
	}
}
