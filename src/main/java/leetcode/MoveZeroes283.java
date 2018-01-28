package leetcode;

/**
 * MoveZeroes283
 */
public class MoveZeroes283 {
	public void moveZeroes(int[] nums) {
		for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
			if (nums[cur] != 0) {
				// swap(nums[lastNonZeroFoundAt++], nums[cur]);
				int temp = nums[cur];
				nums[cur] = nums[lastNonZeroFoundAt];
				nums[lastNonZeroFoundAt++] = temp;
			}
		}
	}

	/* Not Optimal */
	public void moveZeroes0(int[] nums) {
		// find the first non-zero index from the end.
		int zeroNesPos = nums.length - 1;
		while (zeroNesPos >= 0 && nums[zeroNesPos] == 0) zeroNesPos--;

		// find the first zero index from the end.
		int zero = zeroNesPos;
		while (zero >= 0 && nums[zero] != 0) zero--;

		while (zero >= 0) {
			// Because `zero` starts from zeroNewPos,
			// (zero < zeroNewPos) is always true.
			// if (zero < zeroNesPos) {
				for (int i = zero; i < zeroNesPos; i++) nums[i] = nums[i + 1];
				nums[zeroNesPos--] = 0;
				while (zeroNesPos >= 0 && nums[zeroNesPos] == 0) zeroNesPos--;
			// }

			zero = zeroNesPos;
			while (zero >= 0 && nums[zero] != 0) zero--;
		}
	}
}
