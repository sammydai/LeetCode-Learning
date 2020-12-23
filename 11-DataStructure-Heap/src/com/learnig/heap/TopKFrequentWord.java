package com.learnig.heap;

import java.util.*;

/**
 * @Package: com.learnig.heap
 * @Description: 692. Top K Frequent Words
 * @Author: Sammy
 * @Date: 2020/11/22 00:34
 */

public class TopKFrequentWord {
	public static void main(String[] args) {
		String[] nums = {"i", "love", "leetcode", "i", "love", "coding","leetcode","leetcode"};
		String[] nums2 = {"i", "love", "leetcode", "i", "love", "coding"};
		System.out.println(topKFrequent(nums2, 3));
	}
	public static List<String> topKFrequent(String[] words, int k) {
		List<String> result = new LinkedList<>();
		HashMap<String, Integer> countmap = new HashMap<String, Integer>();
		for(String word: words) {
			countmap.put(word, countmap.getOrDefault(word, 0) + 1);
		}
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> (a.fre != b.fre ?
                                                                    b.fre - a.fre :
                                                                    a.word.compareTo(b.word)));

		for (String key : countmap.keySet()) {
			// if (pq.size() < k) {
			// 	pq.add(new Node(key, countmap.get(key)));
			// } else {
			// 	if (countmap.get(key)>=pq.peek().fre) {
			// 		pq.remove();
			// 		pq.add(new Node(key, countmap.get(key)));
			// 	}
			// }
			pq.add(new Node(key, countmap.get(key)));
		}
		while (!pq.isEmpty()&& k>0) {
			result.add(0,pq.poll().word);
			k--;
			// result.add(pq.poll().word);
		}
		return result;
	}
}

class Node {
	public String word;
	public int fre;
	public Node(String word, int fre) {
		this.word = word;
		this.fre = fre;
	}

	@Override
	public String toString() {
		return "Node{" +
				"word='" + word + '\'' +
				", fre=" + fre +
				'}';
	}
}

