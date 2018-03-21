package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumOfSquareNumbers633Test {
	SumOfSquareNumbers633 solution = new SumOfSquareNumbers633();

	@Test
	public void test0() throws Exception {
		assertTrue(solution.judgeSquareSum(5));
		assertFalse(solution.judgeSquareSum(3));
	}

	@Test
	public void test1() throws Exception {
		solution.judgeSquareSum(2147483646);
	}
}