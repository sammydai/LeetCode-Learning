package com.learning.linkedlist;

import com.learning.linkedlist.listnode.ListNode;

/**
 * 206. Reverse Linked List
 * https://leetcode.cn/problems/reverse-linked-list/solutions/36710/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/4/28 15:55]
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode last = reverseList(head.next);
		head.next.next = head;
		head = null;
		return last;
	}

	public ListNode reverseListNew(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}
}
