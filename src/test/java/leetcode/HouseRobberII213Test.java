package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class HouseRobberII213Test {
	HouseRobberII213 solution = new HouseRobberII213();

	@Test
	public void test0() throws Exception {
		assertEquals(1, solution.rob(new int[]{1}));
		assertEquals(1, solution.rob(new int[]{1,1,1}));
		assertEquals(3, solution.rob(new int[]{1,2,1,1}));
	}

	@Test
	public void test1() throws Exception {
		assertEquals(3, solution.rob(new int[]{1,1,1,2}));
	}
}