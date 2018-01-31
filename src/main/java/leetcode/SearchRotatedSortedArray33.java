package leetcode;

/**
 * Created by honey.and.sw on 2018. 1. 31.
 */
public class SearchRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int s, int e) {
        if (s > e) return -1;
        else if (s == e) return nums[s] == target ? s : -1;

        int m = (s + e) / 2;
        if ((nums[s] > nums[m] && nums[e] < target) || (nums[m] > nums[e] && nums[e] >= target)) {
            return nums[m] > target
                    ? search(nums, target, m + 1, e) : search(nums, target, s, m);
        } else {
            return nums[m] >= target
                    ? search(nums, target, s, m) : search(nums, target, m + 1, e);
        }
    }
}
