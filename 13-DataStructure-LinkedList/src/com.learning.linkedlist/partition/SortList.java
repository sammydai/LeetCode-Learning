package com.learning.linkedlist.partition;

import com.learning.linkedlist.listnode.ListNode;

/**
 * 148. Sort List
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/26 14:20]
 */
public class SortList {
	public static ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		if (l1 != null) {
			current.next = l1;
		}
		if (l2 != null) {
			current.next = l2;
		}
		return dummy.next;
	}

	public static ListNode findMid(ListNode head) {
		if (head == null) return head;

		ListNode fast = head.next;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = findMid(head);
		ListNode next = mid.next;
		mid.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(next);
		return merge(left, right);
	}
}
