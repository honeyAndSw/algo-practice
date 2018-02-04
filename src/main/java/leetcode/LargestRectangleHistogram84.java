package leetcode;

import java.util.Stack;

public class LargestRectangleHistogram84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> posStack = new Stack<>();
        Stack<Integer> heightStack = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int curr = heights[i];
            if (heightStack.empty() || heightStack.peek() < curr) {
                posStack.push(i);
                heightStack.push(curr);
            } else {
                int p = 0;
                int h = 0;
                while (!heightStack.empty() && heightStack.peek() > curr) {
                    p = posStack.pop();
                    h = heightStack.pop();
                    max = Math.max(max, h * (i - p));
                }
                if (heightStack.empty() || heightStack.peek() < h) {
                    posStack.push(p);
                    heightStack.push(curr);
                }
            }
        }

        while (!heightStack.empty()) {
            max = Math.max(max, heightStack.pop() * (heights.length - posStack.pop()));
        }

        return max;
    }
}
