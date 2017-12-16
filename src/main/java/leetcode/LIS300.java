package leetcode;

/**
 * 300. Longest Increasing Subsequence
 */
public class LIS300 {
    public int lengthOfLIS(int[] nums) {
        int result = 0;
        int N = nums.length;
        int[] cache = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N ; j++) {
                if (nums[i] < nums[j]) {
                    // {10, 9, 2, 5, 3, 4}
                    // 3 -> 1, 5 -> 0
                    // 2 -> ?
                    cache[i] = Math.max(cache[i], cache[j] + 1);
                }
            }
            result = Math.max(result, cache[i] + 1);
        }

        return result;
    }
}
