package leet;

public class ReverseLink {

	public static void main(String[] args) {
		int[] test = {};
		ListNode list = ListNode.generateList(test);
		ListNode.printWithArrow(list);
		ListNode reverse = reverseList(list);
		ListNode.printWithArrow(reverse);
	}

	
	public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        
        while (cur != null) {
        	ListNode next = cur.next;
        	cur.next = pre;
        	pre = cur;
        	cur = next;
        }
        return pre;
        
    }
}
