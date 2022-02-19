package com.learning.bfs;

import com.learning.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Package: com.learning.bfs
 * @Description: 199. Binary Tree Right Side View
 * @Author: Sammy
 * @Date: 2022/1/26 12:54
 */

public class RightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right!=null) {
					queue.offer(cur.right);
				}
				if (i==size-1) {
					result.add(cur.val);
				}
			}
		}
		return result;
    }
}
