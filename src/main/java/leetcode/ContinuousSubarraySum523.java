package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum523 {

	/*
	 * Solution from discuss:
	 * https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space
	 */
	public boolean checkSubarraySum_solution(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(){
			{put(0,-1);}
		};
		int runningSum = 0;

		for (int i=0;i<nums.length;i++) {
			runningSum += nums[i];
			if (k != 0) runningSum %= k;

			Integer prev = map.get(runningSum);
			// index        i i+1 ... j
			// runningSum%k A  B  ... A
			// At j prev is i, which means that
			// (nums[i+i] + nums[i+2] + ... + nums[j-1]) % k is equal to 0,
			// that (i, j] is the subarray sum to find.
			if (prev != null && i - prev > 1) return true;
			else map.put(runningSum, i);
		}

		return false;
	}

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
