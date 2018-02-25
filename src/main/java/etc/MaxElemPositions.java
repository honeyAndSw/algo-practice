package etc;

import java.util.Random;

public class MaxElemPositions {
    //  0 1 2 3 4 5 6
    // [6 6 6 6 6 6 6]
    // [1 3 6 6 5 4 1]
    int maximum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxNum = -1;
        for (int n : nums) {
            if (n > max) {
                max = n;
                maxNum = 1;
            } else if (n == max) {
                maxNum++;
            }
        }

        int random = new Random().nextInt(maxNum) + 1;
        int maxIndex = 0;
        while (random > 0) {
            if (nums[maxIndex++] == max) {
                random--;
            }
        }

        return maxIndex - 1;
    }
}
