package leetcode;

/**
 * MoveZeroes283
 */
public class MoveZeroes283 {
	public void moveZeroes(int[] nums) {
		// find the first non-zero index from the end.
		int zeroNesPos = nums.length - 1;
		while (zeroNesPos >= 0 && nums[zeroNesPos] == 0) zeroNesPos--;

		// find the first zero index from the end.
		int zero = zeroNesPos;
		while (zero >= 0 && nums[zero] != 0) zero--;

		while (zero >= 0) {
			if (zero < zeroNesPos) {
				for (int i = zero; i < zeroNesPos; i++) nums[i] = nums[i + 1];
				nums[zeroNesPos--] = 0;
				while (zeroNesPos >= 0 && nums[zeroNesPos] == 0) zeroNesPos--;
			}

			zero = zeroNesPos;
			while (zero >= 0 && nums[zero] != 0) zero--;
		}
	}
}
