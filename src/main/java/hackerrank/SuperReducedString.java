package hackerrank;

import java.util.Stack;

public class SuperReducedString {
    public String super_reduced_string(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().charValue() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) return "Empty String";
        else {
            String result = "";
            while (!stack.isEmpty()) result = stack.pop() + result;
            return result;
        }
    }
}
