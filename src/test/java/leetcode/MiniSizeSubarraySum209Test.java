package leetcode;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class MiniSizeSubarraySum209Test {
	MinSizeSubarraySum209 solution = new MinSizeSubarraySum209();

	@Test
	public void test0() throws Exception {
		assertEquals(2, solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
		assertEquals(3, solution.minSubArrayLen(11, new int[]{1,2,3,4,5}));
	}
}