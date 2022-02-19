package com.learning.linkedlist;

import com.learning.linkedlist.listnode.ListNode;

/**
 * @Package: com.learning.linkedlist
 * @Description: 2. Add Two Numbers
 * @Author: Sammy
 * @Date: 2022/1/28 13:09
 */

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode cur = dummy;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int d1 = l1 == null ? 0 : l1.val;
			int d2 = l2 == null ? 0 : l2.val;
			int tempSum = d1 + d2 + carry;
			carry = tempSum >= 10 ? 1 : 0;
			cur.next = new ListNode(tempSum % 10);
			cur = cur.next;
			if (l1!=null) l1 = l1.next;
			if (l2!= null) l2 = l2.next;
		}
		if (carry==1) cur.next = new ListNode(1);
		return dummy.next;
    }
}
