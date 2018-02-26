package leetcode;

public class JumpGame55 {
	public boolean canJump(int[] nums) {
		Boolean[] cache = new Boolean[nums.length];
		return canJump(nums, 0, 0, cache);
	}

	/* Time Limit Exceeded (74/75 passed) */
	private boolean canJump(int[] nums, int pos, int moveAccum, Boolean[] cache) {
		if (pos == nums.length - 1) return true;
		else if (pos >= nums.length) return false;
		else if (cache[pos] != null) return cache[pos];

		if (nums[pos] == 1) {
			while (pos < nums.length - 1 && nums[pos] == 1) {
				pos++;
				moveAccum++;
			}
			return canJump(nums, pos, moveAccum, cache);
		}

		boolean result = false;
		for (int i = nums[pos]; i >= 0; i--) {
			if (i + moveAccum == nums.length - 1 || (i > 0 && canJump(nums, pos + i, moveAccum + i, cache))) {
				result = true;
				break;
			}
		}

		cache[pos] = result;
		return result;
	}

	/**
	 * StackOverFlow Error when `nums` is very long or each of `nums` is a very big integer.
	 *
	 * Time Complexity: O(n^2), because nums[i] can be at most n.
	 * Space Complexity: O(2n) = O(n),
	 * 		O(n) for memoization array
	 * 		O(n) recursion: the height of call stack can be at most n.
	 */
	private boolean canJump0(int[] nums, int pos, Boolean[] cache) {
		if (pos == nums.length - 1) return true;
		else if (pos >= nums.length) return false;
		else if (cache[pos] != null) return cache[pos];

		if (nums[pos] == 1) {
			while (pos < nums.length - 1 && nums[pos] == 1) pos++;
			return canJump0(nums, pos, cache);
		}

		boolean result = false;
		for (int i = 1; i <= nums[pos]; i++) {
			if (canJump0(nums, pos + i, cache)) {
				result = true;
				break;
			}
		}

		cache[pos] = result;
		return result;
	}
}
