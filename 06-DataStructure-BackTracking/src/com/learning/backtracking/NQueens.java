package com.learning.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N-Queens
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/26 16:53]
 */
public class NQueens {

	List<List<String>> res = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
		char[][] chessboard = new char[n][n];
		for (char[] c : chessboard) {
			Arrays.fill(c, '.');
		}
		backTrack(n, 0, chessboard);
		return res;
	}

	public void backTrack(int n, int row, char[][] chessboard) {
		if (row == n) {
			res.add(Array2List(chessboard));
			return;
		}
		for (int col = 0; col < n; ++col) {
			if (isValid(row, col, n, chessboard)) {
				chessboard[row][col] = 'Q';
				backTrack(n, row + 1, chessboard);
				chessboard[row][col] = '.';
			}
		}
	}

	public boolean isValid(int row, int col, int n, char[][] chessboard) {
		//同一列
		for (int i = 0; i < row; i++) {
			if (chessboard[i][col] == 'Q') {
				return false;
			}
		}
		//45对角线
		//所在行row，肯定是从上一行已经放过皇后的行进行处理，这也就是为什么是(i-1,j-1)和(i-1,j+1)
		//而不是i+1行
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chessboard[i][j] == 'Q') {
				return false;
			}
		}
		//135对角线
		//这里的j就是列，是往右边的，那j的限制值是<=n-1,j++
		for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
			if (chessboard[i][j] == 'Q') {
				return false;
			}
		}
		return true;

	}

	public List Array2List(char[][] chessboard) {
		List<String> list = new ArrayList<>();

		for (char[] c : chessboard) {
			list.add(String.copyValueOf(c));
		}
		return list;
	}

}
