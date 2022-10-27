package leet;

public class MergeTwoOrderdList {

	public static void main(String[] args) {
		int[] a1 = {1};
		int[] a2 = {};
		ListNode l1 = ListNode.generateList(a1);
		ListNode l2 = ListNode.generateList(a2);
		ListNode.print(l1);
		ListNode.print(l2);
		ListNode merge = mergeTwoLists(l1, l2);
		ListNode.print(merge);
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode cur = null;
        while (cur1 != null && cur2 != null) {
            if (cur2.val <= cur1.val) {
                if (newHead == null) {
                    newHead = cur2;
                    cur = newHead;
                } else {
                    cur.next = cur2;
                    cur = cur.next;
                }
                cur2 = cur2.next;
            } else {
                if (newHead == null) {
                    newHead = cur1;
                    cur = newHead;
                } else {
                    cur.next = cur1;
                    cur = cur.next;
                }
                cur1 = cur1.next;
            }
        }

        if (cur1 != null) cur.next = cur1;
        if (cur2 != null) cur.next = cur2;

        return newHead;

    }

}
