package leet;

import java.util.HashMap;
import java.util.Map;

public class CopyRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode copyRandomList(ListNode head) {
		Map<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
		ListNode cur = head;
		while (cur != null) {
			ListNode copy = new ListNode(cur.val);
			map.put(cur, copy);
			cur = cur.next;
		}
		
		cur = head;
		while (cur != null) {
			map.get(cur).next = cur.next == null ? null : map.get(cur.next);
			map.get(cur).random = cur.random == null ? null : map.get(cur.random);
			cur = cur.next;
		}
		
		return map.get(head);

	}

}
