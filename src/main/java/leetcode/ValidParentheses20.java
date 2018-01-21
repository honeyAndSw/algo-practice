package leetcode;

import java.util.Stack;

/**
 * Created by honey.and.sw on 2018. 1. 21.
 */
public class ValidParentheses20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (isOpen(ch)) {
                stack.push(ch);
            } else if (!stack.isEmpty() && isOpen(stack.peek()) && isSameType(stack.peek(), ch)) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpen(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private boolean isSameType(char o, char c) {
        switch (o) {
            case '(': return c == ')';
            case '{': return c == '}';
            case '[': return c == ']';
            default: return false; // never reach here.
        }
    }
}
