package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class JumpGame55Test {
	JumpGame55 solution = new JumpGame55();

	@Test
	public void test0() throws Exception {
		int[] nums = new int[25000 + 1];
		for (int i = 25000; i >= 0; i--) {
			nums[25000 - i] = i;
		}

		solution.canJump(nums);
	}
}
