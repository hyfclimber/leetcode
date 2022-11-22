package leet;

import java.util.HashMap;
import java.util.Map;

class DListNode {
    int key;
    int value;
    DListNode pre;
    DListNode next;
    public DListNode(int k, int v) {
        key = k;
        value = v;
    }
    public DListNode(int k, int v, DListNode pre, DListNode next) {
        key = k;
        value = v;
        this.pre = pre;
        this.next = next;
    }
}

public class LRUCache146_2 {

	public static void main(String[] args) {
		LRUCache146_2 c = new LRUCache146_2(2);
		c.put(1, 1);
		c.put(2, 2);
//		c.print();
		c.get(1);
//		c.get(1);
//		c.get(1);
//		c.get(1);
//		c.get(1);
		c.put(3, 3);
//		c.print();
		c.get(2);
//		c.print();
		c.put(4, 4);
//		c.print();
		c.get(1);
		c.get(3);
		c.get(4);
//		c.put(5, 5);
//		c.print();
//		c.put(6, 6);
//		c.print();
//		c.print();
//		c.put(7, 7);
//		c.print();
//		c.put(8, 8);
//		c.print();
//		c.put(9, 9);
//		c.print();

	}

	DListNode head;
    DListNode tail;
    Map<Integer, DListNode> map;
    int size;
    int capacity;
    public LRUCache146_2(int capacity) {
        map = new HashMap<Integer, DListNode>();
        head = new DListNode(-1, -1);
        tail = new DListNode(-1, -1);
        head.next = tail;
        tail.next = head;
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            move2Head(map.get(key));
            return map.get(key).value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
    	if (key == 3) {
    		System.out.println();
    	}
        if (map.containsKey(key)) {
            DListNode n = map.get(key);
            if (n.value != value) {
                n.value = value;
            } 
            move2Head(n);
        } else {
            DListNode node = new DListNode(key, value);
            add2Head(node);
            map.put(key, node);
            if (this.size > this.capacity) {
                map.remove(tail.pre.key);
                removeFromTail();
            }
        }

    }

    public void add2Head(DListNode node) {
        DListNode n = head.next;
        head.next = node;
        node.next = n;
        node.pre = head;
        n.pre = node;
        size++;
    }

    public void remove(DListNode node) {
        DListNode pre = node.pre;
        DListNode next = node.next;
        pre.next = next;
        next.pre = pre;
        size--;
    }

    public void move2Head(DListNode node) {
        remove(node);
        add2Head(node);

    }
    public void removeFromTail() {
        remove(tail.pre);
    }

}
