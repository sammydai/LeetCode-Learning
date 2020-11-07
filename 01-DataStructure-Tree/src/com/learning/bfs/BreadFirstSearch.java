package com.learning.bfs;

import com.learning.tree.TreeNode;

import java.util.*;

/**
 * @Package: com.learning.bfs
 * @Description:
 * @Author: Sammy
 * @Date: 2020/11/7 19:47
 */

public class BreadFirstSearch {
	/**
	 * 广度遍历树bfs
	 * @param root
	 */
	public static void breadFirstSearch(TreeNode root){
		if (root == null) return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node.val+" ");
			if (node.left!=null){
				queue.offer(node.left);
			}if (node.right!=null){
				queue.offer(node.right);
			}
		}
	}


}
