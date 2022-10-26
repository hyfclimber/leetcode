package leet;

public class MergeTwoList {

	public static void main(String[] args) {
		int[] l1 = {1};
		ListNode list1 = ListNode.generateList(l1);
		int[] l2 = {1};
		ListNode list2 = ListNode.generateList(l2);
		
//		ListNode.printWithArrow(list);
		ListNode ans = mergeTwoLists(list1, list2);
		ListNode.printWithArrow(ans);
	}
	
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode head = null;
        ListNode cur = null;
        while (cur1 != null && cur2 != null) {
        	if (cur1.val < cur2.val) {
        		if (head == null) {
        			head = cur1;
        			cur = head;
        		} else {
        			cur.next = cur1;
            		cur = cur.next;
        		}
        		cur1 = cur1.next;
        		
        	} else {
        		if (head == null) {
        			head = cur2;
        			cur = head;
        		} else {
        			cur.next = cur2;
            		cur = cur.next;
        		}
        		cur2 = cur2.next;
        	}	
        }
        if (cur1 != null) cur.next = cur1;
        if (cur2 != null) cur.next = cur2;
        
        return head;
    }

}
