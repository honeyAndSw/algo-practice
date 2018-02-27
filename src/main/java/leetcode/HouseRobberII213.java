package leetcode;

public class HouseRobberII213 {

	/*
	 * HINT
	 * Since House[1] and House[n] are adjacent, they cannot be robbed together.
	 * Therefore, the problem becomes to rob either House[1]-House[n-1] or House[2]-House[n], depending on which choice offers more money.
	 * Now the problem has degenerated to the House Robber, which is already been solved.
	 */
	public int rob(int[] nums) {
		if (nums.length == 1) return nums[0];

		return Math.max(
			robInRange(nums, 0, nums.length - 2),
			robInRange(nums, 1, nums.length - 1)
		);
	}

	private int robInRange(int[] nums, int i0, int i1) {
		if (nums.length == 0) return 0;

		int previous = 0, skipPrevious = 0;
		for (int i = i0; i <= i1; i++) {
			int n = nums[i];
			int previousBak = previous;
			previous = Math.max(previous, skipPrevious + n);
			skipPrevious = previousBak;
		}

		return Math.max(previous, skipPrevious);
	}

	/* Wrong Answer (52/74 passed) */
	public int rob0(int[] nums) {
		int LEN = nums.length;
		int previous = 0, skipPrevious = 0;
		int previousStart = -1, skipPreviousStart = -1;

		for (int i = 0; i < LEN; i++) {
			// Backup previous
			int previousBak = previous;
			int previousStartBak = previousStart;

			if (skipPrevious + nums[i] >= previous
				&& (i + 1 < LEN || (i + 1 >= LEN && (i + 1) % LEN != skipPreviousStart))) {
				// Update previous
				previous = skipPrevious + nums[i];
				previousStart = skipPreviousStart == -1 ? i : skipPreviousStart;
			}

			skipPrevious = previousBak;
			skipPreviousStart = previousStartBak;
		}

		return Math.max(previous, skipPrevious);
	}
}
