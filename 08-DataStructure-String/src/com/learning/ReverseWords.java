package com.learning;


/**
 * 反转单词
 * 151. Reverse Words in a String
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/5 16:33]
 */
public class ReverseWords {
	public static void main(String[] args) {
		System.out.println(reverseWords("a good   example"));
	}

	public static String reverseWords(String s) {
		s = s.trim();
		char[] s_arr = s.toCharArray();
		int len = s.length();
		reverseSentence(s_arr, 0, len - 1);
		reverseEachWord(s_arr, len);
		return clean_space(s_arr, len);

	}

	private static String clean_space(char[] s_arr, int len) {
		int i = 0;
		int j = 0;
		while (j < len) {
			// while (j < len && s_arr[j] == ' ') {
			// 	j++;
			// }
			while (j < len && s_arr[j] != ' ') {
				s_arr[i++] = s_arr[j++];
			}
			while (j < len && s_arr[j] == ' ') {
				j++;
			}
			//加入一个空格
			if (j < len) {
				s_arr[i++] = ' ';
			}
		}
		return new String(s_arr).substring(0, i);
	}


	public static void reverseSentence(char[] arr, int left, int right) {
		while (left <= right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

	public static void reverseEachWord(char[] arr, int len) {
		int left = 0;
		int right = 0;
		while (right < len) {
			while (right < len && arr[right] != ' ') {
				right++;
			}
			reverseSentence(arr, left, right - 1);
			left = right + 1;
			right++;
		}
	}
}
