package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstBadVersion278Test {
	@Test
	public void test0() throws Exception {
		final int first = 1702766719;
		FirstBadVersion278 solution = new FirstBadVersion278() {
			@Override
			boolean isBadVersion(int n) {
				return n >= first; // first bad version
			}
		};

		assertEquals(first, solution.firstBadVersion(2126753390));
	}
}