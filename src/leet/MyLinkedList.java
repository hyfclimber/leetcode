package leet;

public class MyLinkedList {

	public static void main(String[] args) {
		MyLinkedList1 linkedList = new MyLinkedList1();
		linkedList.addAtHead1(7);
		linkedList.print();
		linkedList.addAtHead1(2);
		linkedList.print();
		linkedList.addAtHead1(1);
		linkedList.print();
		linkedList.addAtIndex1(3, 0);
		linkedList.print();
		linkedList.deleteAtIndex1(2);
		linkedList.print();
		linkedList.addAtHead1(6);
		linkedList.print();
		linkedList.addAtTail1(4);
		linkedList.print();
		System.out.println(linkedList.get1(4));
		linkedList.addAtHead1(4);
		linkedList.print();
		linkedList.addAtIndex1(5, 0);
		linkedList.print();
		linkedList.addAtHead1(6);
		linkedList.print();
		linkedList.addAtTail1(1);
		linkedList.print();
		linkedList.addAtTail1(3);
		linkedList.print();
		linkedList.addAtIndex1(10, 20);
		linkedList.print();
		System.out.println(linkedList.get1(1));
	} 

}


//get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
//addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
//addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
//addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
//如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
//deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。



class MyLinkedList1 {
    ListNode head;
    int size;

    public MyLinkedList1() {
        head = null;
        size = 0;
    }
    
    public int get1(int index) {
    	if (head == null) return -1;
    	if (index < 0 || index >= size) return -1;
    	ListNode cur = head;
    	int i = 0;
    	while (cur != null) {
    		if (i == index) {
    			return cur.val;
    		}
    		cur = cur.next;
    		i++;
    	}
        return -1;
    }
    
    public void addAtHead1(int val) {
        addAtIndex1(0, val);
    }
    
    public void addAtTail1(int val) {
    	addAtIndex1(size, val);
    }
    
    public void addAtIndex1(int index, int val) {
    	if (index > size) return;
    	ListNode node  = new ListNode(val);
    	if (head == null) { //空链表
    		head = node;
    		size++;
    		return;
    	}
    	boolean isLast = index == size; //尾部加入
    	ListNode pre = null;
    	ListNode cur = head;
    	int i = 0;
    	while(cur != null) {
    		if (!isLast && i == index) {
    			if (pre == null) {
    				node.next = head;
    				head = node;
    				size++;
    				return;
    			}
    			pre.next = node;
    			node.next = cur;
    			pre = node;
    			size++;
    			return;
    		} else {
    			pre = cur;
    			cur = cur.next;
    		}
    		i++;
    	}
    	//走出循环，即没成功加入，肯定到了末尾。
    	pre.next = node;
    	size++;
    }
    
    public void deleteAtIndex1(int index) {
    	if (head == null) return;
    	if (index < 0 || index >= size) return;
    	ListNode pre = null;
    	ListNode cur = head;
    	int i = 0;
    	while (cur != null) {
    		if (i == index) {
    			if (pre == null) {
    				head = head.next;
    				size--;
    				return;
    			} else {
    				pre.next = cur.next;
    				size--;
    				return;
    			}
    		}
    		pre = cur;
    		cur = cur.next;
    		i++;
    	}
    	size--;
    }
    
    
    
    
    
    
    
    public int get(int index) {
        if (index < 0) return -1;
        int i = 0;
        ListNode cur = head;
        while(cur != null) {
            if (i == index) return cur.val;
            cur = cur.next;
            i++;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
    	ListNode node = new ListNode(val);
    	ListNode nodeNext = head;
        node.next = nodeNext;
        head = node;
        
    }
    
    public void addAtTail(int val) {
    	if (head == null) {
            addAtHead(val);
            return;
        }
    	ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        ListNode node = new ListNode(val);
        cur.next = node;
    }
    
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        int i = 0;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (i == index) {
            	ListNode node = new ListNode(val);
                pre.next = node;
                node.next = cur;
            } 
            pre = cur;
            cur = cur.next;
            i++;
        }
        if (index == i) addAtTail(val);

    }
    
    public void deleteAtIndex(int index) {
        if (index < 0) return;
        if (index == 0) {
        	head = head.next;
        	return;
        }
        int i = 0;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (i == index) {
                pre.next = cur.next;
                return;
            } 
            pre = cur;
            cur = cur.next;
            i++;
        }
    }
    
    
    public void print() {
    	ListNode cur = head;
    	while(cur != null) {
    		System.out.print(cur.val + "->");
    		cur = cur.next;
    	}
    	System.out.print("null");
    	System.out.println();
    }
}
