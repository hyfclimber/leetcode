package leet;

public class DeleteLastN {

	public static void main(String[] args) {
		int[] test = {1, 2, 3};
		ListNode head = ListNode.generateList(test);
		ListNode ans = removeNthFromEnd(head, 1);
		ListNode.print(ans);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        int idx = size - n;
        if (idx == 0) return head.next;

        cur = head;
        int i = 0;
        ListNode pre = null;
        ListNode after = null;
        while (cur != null) {
            if (i  == idx - 1) {
                pre = cur;
            } 
            if (i == idx + 1) {
                after = cur;
            }
            cur = cur.next;
            i++;
        }

        pre.next = after;
        return head;
    }
	
	
	
	
}
