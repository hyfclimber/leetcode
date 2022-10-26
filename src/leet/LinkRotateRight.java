package leet;

public class LinkRotateRight {

	public static void main(String[] args) {

		int[] test = {1,2,3};
		ListNode list = ListNode.generateList(test);
		ListNode.printWithArrow(list);
		ListNode ans = rotateRight(list, 4);
//		ListNode.printWithArrow(ans);
		
	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) return null;
		if (head.next == null) return head;
		
		int size = 0;
		ListNode c = head; 
		while (c != null) {
			c = c.next;
			size++;
		}
		
		
		for (int i = 0; i < k % size; i++) {
			ListNode cur = head; 
			ListNode pre = null;
			
			while (cur.next != null) {
				pre = cur;
				cur = cur.next;
			}
			
			cur.next = head;
			pre.next = null;
			head = cur;
			ListNode.printWithArrow(head);
		}
		
		
		return head;

    }

}
