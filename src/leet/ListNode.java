package leet;

import java.util.HashMap;

//Definition for singly-linked list.

public class ListNode {
	int val;
	ListNode next;
	ListNode random;

	ListNode(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public static ListNode generateList(int[] nums) {
		int N = nums.length;
		ListNode last = null;
		ListNode head = null;
		for (int i = 0; i < N; i++) {
			int ele = nums[i];
			ListNode cur = new ListNode(ele);
			if (last != null) {
				last.next = cur;
				last = cur;
			} else {
				last = cur;
				head = last;
			}

		}
		return head;
	}
	
	public static ListNode generateListWithCycle(int[] nums, int index) {
		int N = nums.length;
		HashMap<Integer, ListNode> cache = new HashMap<Integer, ListNode>();
		ListNode last = null;
		ListNode head = null;
		for (int i = 0; i < N; i++) {
			int ele = nums[i];
			ListNode cur = new ListNode(ele);
			cache.put(i, cur);
			if (last != null) {
				last.next = cur;
				last = cur;
			} else {
				last = cur;
				head = last;
			}
		}
		ListNode enterPoint = cache.get(index);
		last.next = enterPoint;
		return head;
	}
	

	public static void print(ListNode head) {
		if (head == null) {
			System.out.println("[]");
			return;
		}

		ListNode cur = head;
		System.out.print("[");
		while (cur != null) {
			System.out.print(cur.val + ",");
			cur = cur.next;
		}
		System.out.print("]");
		System.out.println();

	}

	public static void printWithArrow(ListNode head) {
		if (head == null) {
			System.out.println("null");
			return;
		}

		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + "->");
			cur = cur.next;
		}
		System.out.print("null");
		System.out.println();

	}

	public static void main(String[] args) {
		int[] test = { 1, 2, 3, 5, 6, 7, 8 };
		ListNode head = generateList(test);
		print(head);
	}
}