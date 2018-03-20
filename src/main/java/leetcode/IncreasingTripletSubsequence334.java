package leetcode;

import java.util.*;

public class IncreasingTripletSubsequence334 {
	/* Wrong Answer */
	public boolean increasingTriplet(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		// index -> sequence in increasing order
		Map<Integer, List<Integer>> cache = new HashMap<>();

		int index = 0;
		while (index < nums.length) {
			if (!stack.isEmpty() && nums[stack.peek()] >= nums[index]) {
				// index를 넣을 수 있을 때 까지 stack에서 꺼내면서 sequence를 생성

				List<Integer> sequence = new LinkedList<>();
				while (!stack.isEmpty() && nums[stack.peek()] >= nums[index]) {
					sequence.add(0, stack.pop());
				}

				if (sequence.size() >= 3) return true;

				/*
				 * In an example with [1,0,10,0,100]:
				 * [0,10] is considered as one sequence
				 * that makes impossible to append 10 to 1 separately.
				 */
				int min = nums[sequence.get(0)];
				for (Integer key : cache.keySet()) { // cache에 sequence를 누적할 수 있는지 확인
					List<Integer> value = cache.get(key);
					if (nums[value.get(value.size() - 1)] < min) {
						value.addAll(sequence);

						if (value.size() >= 3) return true;
						else cache.put(key, value);
					}
				}
				cache.put(min, sequence);
			} else {
				stack.push(index++);
			}
		}

		return stack.size() >= 3;
	}
}
