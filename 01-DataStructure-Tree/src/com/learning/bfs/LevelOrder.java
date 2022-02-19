package com.learning.bfs;

import com.learning.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Collections.reverse;

/**
 * @Package: com.learning.bfs
 * @Description: 102. Binary Tree Level Order Traversal
 * @Author: Sammy
 * @Date: 2022/1/26 11:11
 */

public class LevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root ==null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			// 队列的长度就是每层节点的个数
			int levelNum = queue.size();
			List<Integer> tempResult = new ArrayList<>();
			for (int i = 0; i < levelNum; i++) {
				TreeNode cur = queue.poll();
				tempResult.add(cur.val);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			result.add(tempResult);
		}
		return result;
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
		if (root ==null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			// 队列的长度就是每层节点的个数
			int levelNum = queue.size();
			List<Integer> tempResult = new ArrayList<>();
			for (int i = 0; i < levelNum; i++) {
				TreeNode cur = queue.poll();
				tempResult.add(cur.val);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			result.add(0,tempResult);
		}
		return result;
    }
}
