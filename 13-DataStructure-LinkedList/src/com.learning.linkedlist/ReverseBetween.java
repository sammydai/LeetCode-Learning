package com.learning.linkedlist;

import com.learning.linkedlist.listnode.ListNode;

/**
 * 92. Reverse Linked List II
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/22 23:25]
 */
public class ReverseBetween {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode pre = new ListNode(0, head);
		ListNode reversePre = pre;
		int count = 1;
		//找到反转区间的头节点的上一个节点
		while (count < left) {
			reversePre = reversePre.next;
			count++;
		}
		ListNode reverseHead = reversePre.next;
		//反转区间[left,right]的节点
		ListNode last = null;
		ListNode cur = reverseHead;
		ListNode next;
		while (count <= right) {
			next = cur.next;
			cur.next = last;
			last = cur;
			cur = next;
			count++;
		}
		reversePre.next = last;
		reverseHead.next = cur;
		return pre.next;
	}
}
