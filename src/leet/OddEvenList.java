package leet;

//给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
//第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
//请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
//你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。

//n ==  链表中的节点数
//0 <= n <= 104
//-106 <= Node.val <= 106

public class OddEvenList {

	public static void main(String[] args) {

		int[] test = {1,2,3};
		ListNode list = ListNode.generateList(test);
		ListNode.printWithArrow(list);
		ListNode ans = oddEvenList(list);
		ListNode.printWithArrow(ans);
		
	}

	
	public static ListNode oddEvenList(ListNode head) {
		if (head == null) return null;
		ListNode evenHead = null;
		ListNode evenCur = null;
		ListNode cur = head;
		ListNode pre = null;
		int i = 0;
		while (cur != null) {
			if (i % 2 == 0) {
				pre = cur; 
			} else {
				pre.next = cur.next;
				if (evenHead == null) {
					evenHead = cur;
					evenCur = cur;
				} else {
					evenCur.next = cur;
					evenCur = cur;
				}
			}
			cur = cur.next;
			i++;
		}
		if (evenCur != null) {
			evenCur.next = null;
		}
		pre.next = evenHead;
		return head;

    }
}
