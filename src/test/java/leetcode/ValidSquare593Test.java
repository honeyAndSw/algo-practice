package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidSquare593Test {
	ValidSquare593 solution = new ValidSquare593();

	@Test
	public void test0() throws Exception {
		// 2 p3  p2
		// 1 p1
		// 0 p4
		//       1
		assertFalse(solution.validSquare(new int[]{0,1}, new int[]{1,2}, new int[]{0,2}, new int[]{0,0}));

		assertFalse(solution.validSquare(new int[]{0,0}, new int[]{0,0}, new int[]{0,0}, new int[]{0,0}));
		assertFalse(solution.validSquare(new int []{0,0}, new int []{5,0}, new int []{5,4}, new int []{0,4}));
	}
}