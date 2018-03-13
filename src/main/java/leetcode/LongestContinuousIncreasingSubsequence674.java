package leetcode;

public class LongestContinuousIncreasingSubsequence674 {
	public int findLengthOfLCIS1(int[] nums) {
		int max = 0;
		int start = 0;
		for (int i = 1; i <= nums.length; i++) {
			if (i == nums.length || nums[i-1] >= nums[i]) {
				max = Math.max(max, i - start);
				start = i;
			}
		}

		return max;
	}

	public int findLengthOfLCIS0(int[] nums) {
        int max = 0;
        int start = 0, end = 0;
        while (end < nums.length) {
            if (end == start || nums[end] > nums[end-1]) {
                end++;
            } else {
                max = Math.max(max, end - start);
                start = end;
            }
        }

        return Math.max(max, end - start);
	}
}
