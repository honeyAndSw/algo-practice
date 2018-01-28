package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		return combiSum(candidates, 0, new LinkedList<>(), 0, target);
	}

	private List<List<Integer>> combiSum(int[] candidates, int idx, List<Integer> sum, int accum, int target) {
		if (accum == target) {
			List<Integer> clone = new LinkedList<>(sum);
			List<List<Integer>> result = new LinkedList<>();
			result.add(clone);
			return result;
		} else if (accum > target) {
			return null;
		}

		List<List<Integer>> result = new LinkedList<>();
		for (int i = idx; i < candidates.length; i++) {
			sum.add(candidates[i]);
			List<List<Integer>> list = combiSum(candidates, i, sum, accum + candidates[i], target);
			if (list != null && list.size() > 0) {
				result.addAll(list);
			}
			sum.remove(sum.size() - 1);
		}

		return result;
	}
}
