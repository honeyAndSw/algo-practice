package leetcode;

import java.util.Stack;

public class MinStack155 {
	Stack<Integer> stack;
	Stack<Integer> min;

	/** initialize your data structure here. */
	public MinStack155() {
		stack = new Stack<>();
		min = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if (min.empty() || min.peek() >= x) min.push(x);
	}

	public void pop() {
		int spop = stack.pop();
		if (!min.empty() && min.peek() == spop) min.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min.peek();
	}
}
