package leet;

public class DetectCycle2 {

	public static void main(String[] args) {
		int[] l1 = {3};
		ListNode list1 = ListNode.generateListWithCycle(l1, 1);
		ListNode ans = detectCycle(list1);
		System.out.println(ans == null ? "无环" : ans.val);

	}

	public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == head) return head;
        ListNode slow = head.next;
        ListNode fast = head;
        if (!isNull(fast)) {
            fast = head.next.next;
        } else {
            return null;
        }

        while (!isNull(fast)) {
            if (slow == fast) break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (isNull(fast)) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static boolean isNull(ListNode node) {
        return node == null || node.next == null || node.next.next == null;
    }
    
}
