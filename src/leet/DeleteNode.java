package leet;

public class DeleteNode {

	public static void main(String[] args) {
		int[] arr = {4,1,3};
		ListNode list = ListNode.generateList(arr);
		ListNode.print(list);
		ListNode l = deleteNode(list, 1);
		ListNode.print(l);
	}

	public static ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (cur.val == val) {
            	if (pre == null) {
            		head = cur.next;
            		break;
            	} else {
            		pre.next = cur.next;
                    break;
            	}
            	
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
	
}
