package leetcode;

import java.util.Stack;

public class LargestRectangleHistogram84 {

    /* Only one Stack. */
    public int largestRectangleArea1(int[] heights) {
        Stack<Integer> pos = new Stack<>();
        int max = 0, i = 0;

        while (i < heights.length) {
            if (pos.empty() || heights[pos.peek()] <= heights[i]) {
                pos.push(i++);
            } else {
                int pop = pos.pop();
                max = Math.max(max, pos.empty() ? i * heights[pop] : (i - pos.peek() - 1) * heights[pop]);
            }
        }

        while (!pos.empty()) {
            int pop = pos.pop();
            max = Math.max(max,
                pos.empty() ? heights.length * heights[pop] : (heights.length - pos.peek() - 1) * heights[pop]);
        }

        return max;
    }

    /* Stacks of positions and heights, and they're synchronized. */
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
