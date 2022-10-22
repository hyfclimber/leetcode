package leet;

public class MyLinkedList {

	public static void main(String[] args) {
		MyLinkedList1 linkedList = new MyLinkedList1();
//		linkedList.addAtHead(7);
//		linkedList.print();
//		linkedList.addAtHead(2);
//		linkedList.print();
//		linkedList.addAtHead(1);
//		linkedList.print();
//		linkedList.addAtIndex(3, 0);
//		linkedList.print();
//		linkedList.deleteAtIndex(2);
//		linkedList.print();
//		linkedList.addAtHead(6);
//		linkedList.print();
//		linkedList.addAtTail(4);
//		linkedList.print();
//		System.out.println(linkedList.get(4));
//		linkedList.addAtHead(4);
//		linkedList.print();
//		linkedList.addAtIndex(5, 0);
//		linkedList.print();
//		linkedList.addAtHead(6);
//		linkedList.print();
		linkedList.addAtTail(1);
		linkedList.print();
		linkedList.addAtTail(3);
		linkedList.print();
		System.out.println(linkedList.get(1));
	}

}


class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node next)
    {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList1 {
    Node head;

    public MyLinkedList1() {
        head = null;
    }
    
    public int get(int index) {
        if (index < 0) return -1;
        int i = 0;
        Node cur = head;
        while(cur != null) {
            if (i == index) return cur.val;
            cur = cur.next;
            i++;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        Node nodeNext = head;
        node.next = nodeNext;
        head = node;
        
    }
    
    public void addAtTail(int val) {
    	if (head == null) {
            addAtHead(val);
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        Node node = new Node(val);
        cur.next = node;
    }
    
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        int i = 0;
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            if (i == index) {
                Node node = new Node(val);
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
        Node cur = head;
        Node pre = null;
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
    	Node cur = head;
    	while(cur != null) {
    		System.out.print(cur.val + "->");
    		cur = cur.next;
    	}
    	System.out.print("null");
    	System.out.println();
    }
}
