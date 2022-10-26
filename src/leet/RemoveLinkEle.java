package leet;

//列表中的节点数目在范围 [0, 104] 内
//1 <= Node.val <= 50
//0 <= val <= 50
public class RemoveLinkEle {

	public static void main(String[] args) {
		int[] test = {1};
		ListNode list = ListNode.generateList(test);
		ListNode.printWithArrow(list);
		ListNode remove = removeElements(list, 1);
		ListNode.printWithArrow(remove);
	}
	
	public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        
        ListNode pre = null;
        ListNode cur = head;
        
        while (cur != null) {
        	if (cur.val == val) {
        		pre.next = cur.next;
        	} else {
        		pre = cur;
        	}
        	cur = cur.next;
        }
        
        return head;

    }

}
