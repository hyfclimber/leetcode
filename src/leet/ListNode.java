package leet;

//Definition for singly-linked list.

public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    
    
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
    
    
    public static void main(String[] args) {
    	int[] test = {1,2, 3,5,6,7,8};
		ListNode head = generateList(test);
		print(head);
	}
}