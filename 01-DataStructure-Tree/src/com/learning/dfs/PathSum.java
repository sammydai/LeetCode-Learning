package com.learning.dfs;

import com.learning.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.learning.dfs
 * @Description: 112. Path Sum
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

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
}
