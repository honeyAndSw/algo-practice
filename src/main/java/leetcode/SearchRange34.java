package leetcode;

/**
 * Created by honey.and.sw on 2017. 11. 25.
 */
public class SearchRange34 {
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, target, 0, nums.length - 1);
    }

    private int[] searchRange(int[] nums, int target, int s, int e) {
        if (s > e) {
            return new int[]{-1, -1};
        }

        int m = (s + e) / 2;
        if (nums[m] < target) {
            // Range is on the right half of nums.
            return searchRange(nums, target, m + 1, e);
        } else if (nums[m] > target) {
            // Range is on the left half of nums.
            return searchRange(nums, target, s, m - 1);
        } else {
            int r0 = -1, r1 = -1;
            for (int i = s; i <= e; i++) {
                if (nums[i] == target) {
                    if (r0 == -1) r0 = i;
                    r1 = i;
                }
            }
            return new int[]{r0, r1};
        }
    }
}
