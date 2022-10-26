package leet;

public class AddTwoNum {

	public static void main(String[] args) {
		int[] l1 = {9,9,9,9,9,9};
		ListNode list1 = ListNode.generateList(l1);
		int[] l2 = {1,2,3};
		ListNode list2 = ListNode.generateList(l2);
		
//		ListNode.printWithArrow(list);
		ListNode ans = addTwoNumbers(list1, list2);
		ListNode.printWithArrow(ans);
		
	}
	
public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = null;
        ListNode newCur = null;
        int ad = 0;
        while (cur1 != null || cur2 != null || ad != 0) {
            int v = (cur1 == null ? 0 : cur1.val)+ (cur2 == null ? 0 : cur2.val) + ad;
            int val = v % 10;
            ad = v / 10;
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
                newCur = node;
            } else {
                newCur.next = node;
                newCur = node;
            }
            if (cur1 != null) cur1 = cur1.next;
            if (cur2 != null) cur2 = cur2.next;
        }
        return head;
    }

}
