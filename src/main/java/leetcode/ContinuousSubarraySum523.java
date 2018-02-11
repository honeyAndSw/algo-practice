package leetcode;

public class ContinuousSubarraySum523 {
	public boolean checkSubarraySum(int[] nums, int k) {
		k = Math.abs(k);

		for (int i = 0; i < nums.length - 1; i++) {
			// Make prefix sum that has at least 2 elems.
			int[] prefixSum = new int[nums.length - i];
			for (int j = 0; j < prefixSum.length; j++) {
				prefixSum[j] = (j == 0) ? nums[i] : prefixSum[j-1] + nums[j+i];

				if ((j > 0) && (
					(k > 0 && prefixSum[j] % k == 0) || (k == 0 && j == 1 && prefixSum[j] == 0)
				)) {
					return true;
				}
			}

			// Originally tried binary search of (k * n) from prefixSum,
			// but later observation is that I could do it when making prefixSum.
		}

		return false;
	}
}
