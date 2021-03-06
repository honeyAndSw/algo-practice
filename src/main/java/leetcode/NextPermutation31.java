package leetcode;

import java.util.Arrays;

/**
 * Created by honey.and.sw on 2018. 1. 7.
 */
public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;

        int idx = nums.length - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
            // Breaks if nums[idx] < nums[idx+1]
            idx--;
        }

        if (idx < 0) {
            // `nums` is sorted in descending order.
            // Sort it in ascending order and return immediately.
            Arrays.sort(nums);
            return;
        }

        // 0, ... , idx, idx+1, ... , N-1
        // We found `idx` so far where:
        // [idx+1, N-1] in descending order.
        // 1) `idx` should be incremented (or switched to the closest larger element)
        // 2) and [idx+1, N-1] should be sorted in ascending order
        // for the next permutation.

        int nextIdx = minMaxIndex(nums, idx);
        switchElems(nums, idx, nextIdx); // 1)
        Arrays.sort(nums, idx + 1, nums.length); // 2)
    }

    private int minMaxIndex(int[] nums, int compare) {
        int nextIdx = compare + 1;
        for (int i = nextIdx; i < nums.length; i++) {
            if (nums[i] > nums[compare] && nums[i] < nums[nextIdx]) {
                nextIdx = i;
            }
        }
        return nextIdx;
    }

    private void switchElems(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
