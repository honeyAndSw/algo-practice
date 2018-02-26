package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CountSmallerNumbersAfterSelf315 {

	// solution2 ----------------------------------

	class TreeNode {
		int val, leftCount;
		TreeNode left, right;

		TreeNode(int v) {
			this.val = v;
		}
	}

	public List<Integer> countSmaller(int[] nums) {
		Integer[] result = new Integer[nums.length];
		TreeNode head = null;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (head == null) {
				head = new TreeNode(nums[i]);
				result[i] = 0;
			} else {
				result[i] = insert(head, nums[i], 0);
			}
		}

		return Arrays.asList(result);
	}

	private int insert(TreeNode head, int num, int smallerNums) {
		if (head.val > num) {
			head.leftCount++;
			if (head.left == null) {
				head.left = new TreeNode(num);
				return smallerNums;
			} else {
				return insert(head.left, num, smallerNums);
			}
		} else {
			int nextSmallerNums = (head.val == num ? 0 : 1) + smallerNums + head.leftCount;
			if (head.right == null) {
				head.right = new TreeNode(num);
				return nextSmallerNums;
			} else {
				return insert(head.right, num, nextSmallerNums);
			}
		}
	}

	// solution1 ----------------------------------

	public List<Integer> countSmaller1(int[] nums) {
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
