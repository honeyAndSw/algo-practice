package leetcode;

import static org.junit.Assert.*;

import leetcode.utils.Lists;
import org.junit.Test;

public class CountSmallerNumbersAfterSelf315Test {
	CountSmallerNumbersAfterSelf315 solution = new CountSmallerNumbersAfterSelf315();

	@Test
	public void test0() throws Exception {
		assertArrayEquals(new int[]{2,1,1,0},
			Lists.toArray(solution.countSmaller(new int[]{5,2,6,1})));
	}
}