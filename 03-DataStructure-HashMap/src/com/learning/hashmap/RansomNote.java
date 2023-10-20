package com.learning.hashmap;

/**
 * 383. Ransom Note
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/7/10 14:55]
 */
public class RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] a = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			a[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			a[ransomNote.charAt(i) - 'a']--;
			if (a[ransomNote.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
}
