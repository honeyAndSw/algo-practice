package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PermutationsII47
 */
public class PermutationsII47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		return permuteUnique(nums, new boolean[nums.length], 0, new int[nums.length]);
	}

	private List<List<Integer>> permuteUnique(int[] nums, boolean[] used, int ri, int[] result) {
		LinkedList<List<Integer>> list = new LinkedList<>();

		if (ri == nums.length) {
			List<Integer> resultList = Arrays.stream(result).boxed().collect(Collectors.toList());
			list.add(resultList);
			return list;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;

			result[ri] = nums[i];
			used[i] = true;
			list.addAll(permuteUnique(nums, used, ri + 1, result));
			used[i] = false;
		}

		return list;
	}
}
