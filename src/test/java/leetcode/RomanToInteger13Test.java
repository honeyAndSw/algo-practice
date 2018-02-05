package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanToInteger13Test {
	RomanToInteger13 solution = new RomanToInteger13();

	@Test
	public void test0() throws Exception {
		assertEquals(4, solution.romanToInt1("IV"));
	}
}