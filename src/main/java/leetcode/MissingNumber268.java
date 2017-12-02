package leetcode;

import java.util.stream.IntStream;

/**
 * Created by honey.and.sw on 2017. 12. 2.
 */
public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        // int sum = IntStream.range(0, nums.length + 1).sum();
        // return sum - IntStream.of(nums).sum();

        // Do the same thing in one iteration.
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + i - nums[i];
        }
        return sum;
    }

    // Not Accepted.
    // Because Integer.MAX_VALUE = 2^31 - 1, flag hits the maximum very soon.
    public int missingNumber0(int[] nums) {
        int max = nums.length;
        int flag = 0;
        for (int n : nums) {
            flag = flag | (1 << n);
        }
        int mask = (1 << (max + 1)) - 1;
        int missing = flag ^ mask;

        int count = 0;
        while (missing > 1) {
            count++;
            missing = missing >> 1;
        }

        return count;
    }
}
