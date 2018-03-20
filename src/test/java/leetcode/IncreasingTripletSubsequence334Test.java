package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class IncreasingTripletSubsequence334Test {
	IncreasingTripletSubsequence334 solution = new IncreasingTripletSubsequence334();

	@Test
	public void test0() throws Exception {
		assertFalse(solution.increasingTriplet(new int[]{2,1,5,0,3}));
		assertTrue(solution.increasingTriplet(new int[]{1,2,3,1,2,1}));
	}

	@Test
	public void test1() throws Exception {
		assertTrue(solution.increasingTriplet(new int[]{1,0,10,0,100000000}));
	}
}