package leet;

import java.util.Arrays;

public class ReversePrint {

	public static void main(String[] args) {

		int[] l1 = {1,2,3,4};
		ListNode list1 = ListNode.generateList(l1);
		int[] ans = reversePrint(list1);
		System.out.println(Arrays.toString(ans));
	}
	
	public static int[] reversePrint(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        int i = 0;
        while (cur != null) {
            ListNode node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
            i++;
        }
        ListNode.print(pre);
        System.out.println(i);
        int[] ans = new int[i];
        cur = pre;
        i = 0;
        while (cur != null) {
            ans[i] = cur.val;
            cur = cur.next;
            i++;
        }
        return ans;
    }

}
