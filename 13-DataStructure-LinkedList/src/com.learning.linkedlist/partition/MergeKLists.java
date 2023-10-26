package com.learning.linkedlist.partition;

import com.learning.linkedlist.listnode.ListNode;

/**
 * 23. Merge k Sorted Lists
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/26 15:44]
 */
public class MergeKLists {
	public static ListNode merge2Lists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val < l2.val) {
			l1.next = merge2Lists(l1.next, l2);
			return l1;
		}
		l2.next = merge2Lists(l1, l2.next);
		return l2;
	}

	public static ListNode merge2ListsNew(ListNode l1, ListNode l2) {
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
		current.next = l1 == null ? l2 : l1;
		return dummy.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode res = null;
		for (ListNode list : lists) {
			res = merge2Lists(res, list);
		}
		return res;
	}

}
