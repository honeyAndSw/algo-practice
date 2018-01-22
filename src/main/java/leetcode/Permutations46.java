package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Permutations46
 */
public class Permutations46 {
	public List<List<Integer>> permute(int[] nums) {
		int[] count = new int[nums.length];
		Arrays.fill(count, 1);
		return permutate(nums, count, 0, new int[nums.length]);
	}

	/**
	 * With `count` array,
	 * it's also possible to generate permutations of `nums` that has duplicated elements.
	 * But #46 Permutations's input is limited to unique element `nums`.
	 */
	private List<List<Integer>> permutate(int[] nums, int[] count, int ri, int[] result) {
		LinkedList<List<Integer>> list = new LinkedList<>();

		if (ri == nums.length) {
			List<Integer> resultList = Arrays.stream(result).boxed().collect(Collectors.toList());
			list.add(resultList);
			return list;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0) continue;

			result[ri] = nums[i];
			count[i] -= 1;
			list.addAll(permutate(nums, count, ri + 1, result));
			count[i] += 1;
		}

		return list;
	}
}
