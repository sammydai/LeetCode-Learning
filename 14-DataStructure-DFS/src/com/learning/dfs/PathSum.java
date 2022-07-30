package com.learning.dfs;

import com.learning.tree.TreeNode;
import sun.jvm.hotspot.gc_implementation.parallelScavenge.ParallelScavengeHeap;

import java.awt.font.TextMeasurer;
import java.util.*;

/**
 * @Package: com.learning.dfs
 * @Description: 112. Path Sum
 * 				 113. Path Sum II
 * @Author: Sammy
 * @Date: 2020/11/15 22:28
 */

public class PathSum {
	public static boolean hasPathSum(TreeNode root, int sum) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return false;
		}
		pathsum(root, 0, result,sum);
		System.out.println(result);
		return result.contains(sum);
	}

	public boolean hasPathSumPlus(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSumPlus(root.left, sum - root.val) || hasPathSumPlus(root.right, sum - root.val);
    }

	public static void pathsum(TreeNode root, int tempSum, List<Integer> result, int sum) {
		tempSum += root.val;
		if (root.left != null) {
			pathsum(root.left, tempSum, result, sum);
		}
		if (root.right != null) {
			pathsum(root.right, tempSum, result, sum);
		}
		if (root.right == null && root.left == null) {
			result.add(tempSum);
			return;
		}
	}

	public static void main(String[] args) {
		TreeNode cc = new TreeNode(1, null,null);
		TreeNode aa = new TreeNode(23, null,cc);
		TreeNode bb = new TreeNode(8, null,null);
		TreeNode dd = new TreeNode(72,null,null);
		TreeNode rl = new TreeNode(9,aa,bb);
		TreeNode rr =new TreeNode(20,null,dd);
		TreeNode root = new TreeNode(3, rl,rr);
		hasPathSum(root, 21);
	}

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		if (root == null) return result;
		helper(root, targetSum, 0, result, tempResult);
		return result;
	}

	private void helper(TreeNode root, int targetSum,int tempSum, List<List<Integer>> result, List<Integer> tempResult) {
		if (root==null) {
			return;
		}
		tempResult.add(root.val);
		tempSum += root.val;
		if (root.left == null && root.right == null && tempSum == targetSum) {
			result.add(new ArrayList<>(tempResult));
			return;
		}
		if (root.left != null) {
			helper(root.left,targetSum,tempSum,result,tempResult);
			tempResult.remove(tempResult.size() - 1);
		}
		if (root.right != null) {
			helper(root.right,targetSum,tempSum,result,tempResult);
			tempResult.remove(tempResult.size() - 1);
		}
	}

	//把堆栈理解为存储TreeNode的数据结构
	//不要试图理解出入栈的所有细节，这样会想不通
	//当进入一个节点，会把它的相邻节点，也入栈到stack中
	//然后出栈最顶层的节点，去判断是不是叶子节点，是不是target==sum
	//如果是叶子节点，不符合target==sum，就已经出栈了，再进行下一次循环，这个时候已经退到上一个节点了，
	// 说明这条路不通，也就是dfs算法的要点，不通就回到上一个阶段
	public boolean hasPathSumStack(TreeNode root, int sum) {
		Stack<TreeNode> path = new Stack<>();
		Stack<Integer> sub = new Stack<>();
		if (root == null) return false;
		path.push(root);
		sub.push(root.val);
		while (!path.isEmpty()) {
			TreeNode temp = path.pop();
			int temVal = sub.pop();
			if (temp.left == null && temp.right == null && temVal == sum) return true;
			else {
				if (temp.left != null) {
					path.push(temp.left);
					sub.push(temVal + temp.left.val);
				}
				if (temp.right!=null){
					path.push(temp.right);
					sub.push(temVal + temp.right.val);
				}
			}
		}
		return false;
	}
}
