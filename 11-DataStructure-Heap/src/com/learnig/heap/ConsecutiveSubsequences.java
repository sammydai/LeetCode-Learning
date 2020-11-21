package com.learnig.heap;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Package: com.learnig.heap
 * @Description: 659. Split Array into Consecutive Subsequences 将数组分割成连续子序列
 * @Author: Sammy
 * @Date: 2020/11/21 23:08
 */

public class ConsecutiveSubsequences {
	public static void main(String[] args) {
		int[] num1 = {1, 2, 3, 3, 4, 5, 7};
		int[] num2 = {1, 2, 3, 3, 4, 4, 5, 5, 7};
		System.out.println(isPossible(num1));
	}

	 public static boolean isPossible(int[] nums) {
		 PriorityQueue<IntervalArray> pq = new PriorityQueue<>(new Comparator<IntervalArray>() {
			 @Override
			 public int compare(IntervalArray a, IntervalArray b) {
			 	 if (a.end == b.end) {
                    return Integer.compare(a.length, b.length);
                }
                return Integer.compare(a.end, b.end);
			 }
		 });
		 for (int num : nums) {
			 while (!pq.isEmpty() && pq.peek().end + 1 < num) {
				 if (pq.poll().length<3) {
					 return false;
				 }
			 }
			 if (pq.isEmpty() || pq.peek().end == num) {
				 pq.add(new IntervalArray(num, num));
			 } else {
				 pq.add(new IntervalArray(pq.poll().start, num));
			 }
		 }
		 while (!pq.isEmpty()) {
			 if (pq.poll().length<3) {
				 return false;
			 }
		 }
		 return true;
	 }
}

class IntervalArray{
	public int start;
	public int end;
	public int length;

	public IntervalArray(int start, int end) {
		this.start = start;
		this.end = end;
		this.length = end-start+1;
	}

	@Override
	public String toString() {
		return "IntervalArray{" +
				"start=" + start +
				", end=" + end +
				", length=" + length +
				'}';
	}
}
