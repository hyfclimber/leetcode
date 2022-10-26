package leet;

public class MiddleNode {

	public static void main(String[] args) {
		int[] l1 = {};
		ListNode list1 = ListNode.generateList(l1);
		ListNode ans = middleNode(list1);
//		ListNode.printWithArrow(ans);
		System.out.println(ans.val);
	}
	
	public static ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow.next == null || fast.next == null) {
            return slow;
        } else {
            return slow.next;
        }
    }

}
