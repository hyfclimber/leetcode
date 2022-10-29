package leet;


//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
//
//示例:
//
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.

class MinStack {
    Node head;
    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(head.min, x), head);
        }
    }
    
    public void pop() {
        if (head != null) head = head.next;
    }
    
    public int top() {
        return head == null ? null : head.val;
    }
    
    public int min() {
        return head == null ? Integer.MAX_VALUE : head.min;
    }
}

class Node {
    int val;
    Node next;
    int min; //当前节点加入后，栈中的最小值。
    public Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */