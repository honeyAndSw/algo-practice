package leetcode;

public class HouseRobber198 {

	public int rob0(int[] nums) {
		int LEN = nums.length;
		if (LEN == 0) return 0;

		int[] money = new int[3];
		for (int i = 0; i < LEN; i++) {
			money[i % 3] = Math.max(nums[i] + money[(i - 2 + 3) % 3], money[(i - 1 + 3) % 3]);
		}

		return money[(LEN - 1) % 3];
	}

	public int rob1(int[] nums) {
		int LEN = nums.length;
		if (LEN == 0) return 0;

		int[] money = new int[3];
		for (int i = LEN - 1; i >= 0; i--) {
			money[i % 3] = Math.max(nums[i] + money[(i + 2) % 3], money[(i + 1) % 3]);
		}

		return money[0];
	}
}
