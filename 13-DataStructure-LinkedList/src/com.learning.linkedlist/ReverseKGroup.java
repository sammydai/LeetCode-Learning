package com.learning.linkedlist;

import com.learning.linkedlist.listnode.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/23 14:53]
 */
public class ReverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode tail = head;
		for (int i = 0; i < k; i++) {
			// 剩余数量<k,不需要反转
			if (tail == null) {
				return head;
			}
			tail = tail.next;
		}
		ListNode newHead = reverse(head, tail);
		head.next = reverseKGroup(tail, k);
		return newHead;
	}

	public ListNode reverse(ListNode head, ListNode tail) {
		ListNode pre = null;
		ListNode next = null;
		while (head != tail) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
			// ListNode temp = cur.next;
			// cur.next=pre;
			// pre = cur;
			// cur = temp;
		}
		return pre;
	}
}
