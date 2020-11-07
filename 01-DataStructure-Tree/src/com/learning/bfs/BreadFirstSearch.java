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
	public static void main(String[] args) {
		TreeNode cc = new TreeNode(1, null,null);
		TreeNode aa = new TreeNode(23, null,cc);
		TreeNode bb = new TreeNode(8, null,null);
		TreeNode dd = new TreeNode(72,null,null);
		TreeNode rl = new TreeNode(9,aa,bb);
		TreeNode rr =new TreeNode(20,null,dd);
		// TreeNode t1 = new TreeNode(15,null,null);
		// TreeNode t2 = new TreeNode(7,null,null);
		// TreeNode rl = new TreeNode(9,null,null);
		// TreeNode rr = new TreeNode(20,t1,t2);
		TreeNode root = new TreeNode(3, rl,rr);
		// System.out.println("breadFirstSearch:");
		// System.out.println("-----------------");
		// breadFirstSearch(root);
		System.out.println("breadFirstSearch1:");
		System.out.println("-----------------");
		System.out.println(breadFirstSearch1(root));
	}

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

	public static List<List<Integer>> breadFirstSearch1(TreeNode root){
		if (root ==null) return null;
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> tempResult = new ArrayList<>();
			for (int i = queue.size(); i > 0; i--) {
				TreeNode treeNode = queue.poll();
				tempResult.add(treeNode.val);
				if (treeNode.left != null) {
					queue.offer(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.offer(treeNode.right);
				}
			}
			result.add(tempResult);
		}
		return result;
	}
}
