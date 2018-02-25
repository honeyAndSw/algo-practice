package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CountSmallerNumbersAfterSelf315 {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> result = new LinkedList<>();
		List<Integer> sorted = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int pos = position(sorted, nums[i], 0, sorted.size() - 1);
			result.add(0, pos + 1);
			sorted.add(pos + 1, nums[i]);
		}

		return result;
	}

	/**
	 * Returns the position of biggest integer that is less than target
	 */
	private int position(List<Integer> list, int target, int start, int end) {
		if (list.size() == 0) return -1;
		else if (list.get(start) >= target) return start - 1;
		else if (list.get(end) < target) return end;

		int mid = (start + end) / 2;
		if (list.get(mid) >= target) return position(list, target, start, mid);
		else return position(list, target, mid + 1, end);
	}
}
