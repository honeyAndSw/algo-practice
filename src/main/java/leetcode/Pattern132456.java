package leetcode;

import java.util.Stack;

/**
 * Created by honey.and.sw on 2017. 12. 17.
 */
public class Pattern132456 {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> backupStack = new Stack<>();

        for (int num : nums) {
            while (!numStack.isEmpty() && numStack.peek() >= num) {
                backupStack.push(numStack.pop());
            }

            while (!backupStack.isEmpty() && backupStack.peek() <= num) {
                numStack.push(backupStack.pop());
            }

            numStack.push(num);

            if (numStack.size() >= 2 && !backupStack.isEmpty() && numStack.peek() < backupStack.peek()) {
                return true;
            }
        }

        return false;
    }
}
