package leetcode30Challenge;

import java.util.Stack;

public class MinStack {

    /** initialize your data structure here. */
	Stack<Node> stack;
    public MinStack() {
        stack = new Stack<>();
        stack.push(new Node(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
    
    public void push(int x) {
        int minValue = Math.min(x, stack.peek().getMinValue());
        stack.push(new Node(x,minValue));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getValue();
    }
    
    public int getMin() {
        return stack.peek().getMinValue();
    }
    
    public static void main(String[] args) {
    	MinStack myStack = new MinStack();
    	myStack.push(-2);
    	myStack.push(0);
    	myStack.push(-3);
    	myStack.getMin();
    	myStack.pop();
    	myStack.top();
    	myStack.getMin();
    }
}

class Node{
	public Node(int value, int minValue) {
		super();
		this.value = value;
		this.minValue = minValue;
	}
	public int getValue() {
		return value;
	}
	public int getMinValue() {
		return minValue;
	}
	int value;
	int minValue;
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */