package com.learning.linkedlist;

import com.learning.linkedlist.listnode.ListNode;

/**
 * 61. Rotate List
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/22 23:14]
 */
public class RotateRight {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) return head;
		ListNode node = head;
		int n = 1;
		while (node.next != null) {
			n++;
			node = node.next;
		}
		k %= n;
		if (k == 0) return head;
		ListNode tail = node;
		node = head; //重新遍历
		while (n-- > k + 1) {
			node = node.next;
		} //找到新头节点的前一个节点，即n-k个节点
		tail.next = head; //原来的尾部节点tail，的next 指向头节点head
		ListNode newHead = node.next; //新的头节点是 node.next
		node.next = null; //再把 找到新头节点的前一个节点，即n-k个节点 的下一个节点置空
		return newHead;
	}
}
