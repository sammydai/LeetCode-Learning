package com.learning.linkedlist;

import com.learning.linkedlist.listnode.ListNode;

/**
 * @Package: com.learning.linkedlist
 * @Description: 21. Merge Two Sorted Lists
 * @Author: Sammy
 * @Date: 2022/2/15 09:59
 */

public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if(list1 == null) return list2;
        else if(list2 == null) return list1;
		ListNode dummy = new ListNode();
		ListNode cur = dummy;
		while (list1 != null && list2 != null) {
			int d1 = list1.val;
			int d2 = list2.val;
			if (d1 <= d2) {
				cur.next = new ListNode(d1);
				list1 = list1.next;
			} else {
				cur.next = new ListNode(d2);
				list2 = list2.next;
			}
			cur = cur.next;
		}
		cur.next = list1 == null ? list2 : list1;
		while (list1 != null) {
			cur.next = new ListNode(list1.val);
			list1 = list1.next;
			cur = cur.next;
		}
		while (list2 != null) {
			cur.next = new ListNode(list2.val);
			list2 = list2.next;
			cur = cur.next;
		}
		return dummy.next;
	}

}
