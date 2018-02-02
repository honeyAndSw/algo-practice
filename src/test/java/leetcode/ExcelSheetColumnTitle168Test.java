package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExcelSheetColumnTitle168Test {
	ExcelSheetColumnTitle168 solution = new ExcelSheetColumnTitle168();

	@Test
	public void test0() throws Exception {
		assertEquals("A", solution.convertToTitle(1));
		assertEquals("Z", solution.convertToTitle(26));
		assertEquals("AZ", solution.convertToTitle(52));
		assertEquals("ZZ", solution.convertToTitle(702));
		assertEquals("AAA", solution.convertToTitle(26 * 26 + 26 + 1));
	}
}