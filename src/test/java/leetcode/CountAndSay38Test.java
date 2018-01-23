package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CountAndSay38Test
 */
public class CountAndSay38Test {
	CountAndSay38 solution = new CountAndSay38();

	@Test
	public void test0() throws Exception {
		String[] expected = {
			"1",
			"11",
			"21",
			"1211",
			"111221",
			"312211",
			"13112221",
			"1113213211",
			"31131211131221",
			"13211311123113112211"
		};

		for (int n = 1; n <= expected.length; n++) {
			assertEquals(expected[n-1], solution.countAndSay(n));
		}
	}
}
