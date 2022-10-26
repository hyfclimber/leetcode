package leet;

import java.util.Stack;

public class Palindrome {

	public static void main(String[] args) {

		int[] test = {};
		ListNode list = ListNode.generateList(test);
		ListNode.printWithArrow(list);
		boolean ans = isPalindrome(list);
		System.out.println(ans);
	}
	
	public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
        	stack.push(cur);
        	cur = cur.next;
        }
        cur = head;
        while (cur != null) {
        	ListNode top = stack.pop();
        	if (top.val != cur.val) return false;
        	cur = cur.next;
        }
        
        return true;

    }

}
