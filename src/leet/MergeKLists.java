package leet;

public class MergeKLists {

	public static void main(String[] args) {
		int[] n1 = {1, 4, 5};
		int[] n2 = {1,3,4};
		int[] n3 = {2,6};
		ListNode l1 = ListNode.generateList(n1);
		ListNode l2 = ListNode.generateList(n2);
		ListNode l3 = ListNode.generateList(n3);
//		ListNode[] ns = {l1, l2, l3};
		ListNode[] ns = {};
		ListNode ans = mergeKLists(ns);
		ListNode.print(ans);
		
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		ListNode cur = lists[0];
		for (int i = 1; i < lists.length; i++) {
			cur = mergeTwoLists(cur, lists[i]);
		}
		return cur;
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode head = null;
		ListNode cur = null;
		while (l1 != null && l2 != null) {
			int v1 = l1.val;
			int v2 = l2.val;
			if (v1 <= v2) {
				if (head == null) {
					head = l1;
					cur = head;
				} else {
					cur.next = l1;
					cur = cur.next;
				}
				l1 = l1.next;
			} else {
				if (head == null) {
					head = l2;
					cur = head;
				} else {
					cur.next = l2;
					cur = cur.next;
				}
				l2 = l2.next;
			}
		}
		
		if (l1 != null) cur.next = l1;
		if (l2 != null) cur.next = l2;
		
		return head;
	}

}
