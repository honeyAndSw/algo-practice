package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllNumsDisappearedInArray448 {
	/* 13.18% runtime */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		Arrays.sort(nums);

		List<Integer> result = new LinkedList<>();
		int LEN = nums.length, pointer = 1, i = 0;

		while (pointer <= LEN) {
			if (i > 0 && i < LEN && nums[i-1] == nums[i]) i++;
			else if (i < LEN && nums[i] == pointer) {
				i++;
				pointer++;
			} else {
				result.add(pointer++);
			}
		}

		return result;
	}
}
