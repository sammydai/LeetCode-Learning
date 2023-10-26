package com.learning.backtracking;

/**
 * 79. Word Search
 * <p>
 * https://leetcode.cn/problems/word-search/solutions/2361646/79-dan-ci-sou-suo-hui-su-qing-xi-tu-jie-5yui2/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 递归参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
 * 终止条件：
 * 返回 falsefalsefalse ： (1) 行或列索引越界 或 (2) 当前矩阵元素与目标字符不同 或 (3) 当前矩阵元素已访问过 （ (3) 可合并至 (2) ） 。
 * 返回 truetruetrue ： k = len(word) - 1 ，即字符串 word 已全部匹配。
 * 递推工作：
 * 标记当前矩阵元素： 将 board[i][j] 修改为 空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问。
 * 搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需找到一条可行路径就直接返回，不再做后续 DFS ），并记录结果至 res 。
 * 还原当前矩阵元素： 将 board[i][j] 元素还原至初始值，即 word[k] 。
 * 返回值： 返回布尔量 res ，代表是否搜索到目标字符串。
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/26 15:59]
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		char[] words = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (helper(board, words, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean helper(char[][] board, char[] words, int i, int j, int k) {
		if (k == words.length) return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[k]) return false;
		board[i][j] = '\0';
		boolean res = helper(board, words, i + 1, j, k + 1) || helper(board, words, i - 1, j, k + 1) || helper(board, words, i, j + 1, k + 1) || helper(board, words, i, j - 1, k + 1);
		board[i][j] = words[k];
		return res;
	}
}
