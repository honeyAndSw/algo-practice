package leetcode;

public class MinSizeSubarraySum209 {
	public int minSubArrayLen(int s, int[] nums) {
		int[] psum = prefixSum(nums);
		return minSubArrayLen(s, psum, 0, psum.length - 1);
	}

	private int[] prefixSum(int[] nums) {
		int[] psum = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			psum[i] = (i == 0) ? nums[i] : psum[i-1] + nums[i];
		}
		return psum;
	}

	private int minSubArrayLen(int s, int[] psum, int from, int to) {
		if (from > to || psum[to] < s) return 0;

		int sPos = binarySearch(s, psum, from, to);
		if (sPos < from) {
			return 1; // only psum[from] is enough.
		} else if (sPos > to) {
			return 0;
		} else {
			int length = sPos - from + 1;
			int right = minSubArrayLen(s + psum[sPos], psum, sPos + 1, to);
			return right == 0 ? length : Math.min(length, right);
		}
	}

	// Where's the element less than or equal to target?
	private int binarySearch(int target, int[] array, int from, int to) {
		if (target < array[from]) return from - 1;
		else if (target == array[from]) return from;
		else if (target >= array[to]) return to;

		int mid = (from + to) / 2;
		if (array[mid] <= target && mid + 1 <= to && target < array[mid+1]) return mid;
		else if (array[mid] <= target) return binarySearch(target, array, mid + 1, to);
		else return binarySearch(target, array, from, mid - 1);
	}
}
