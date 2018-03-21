package leetcode;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MaximalSquare221Test {
	MaximalSquare221 solution = new MaximalSquare221();

	private void assertEquals(char[][] matrix, int expected) {
		Assert.assertEquals(expected, solution.maximalSquare1(matrix));
	}

	@Test
	public void test0() throws Exception {
		assertEquals(
			new char[][]{
				new char[]{'1','0','1','0','0'},
				new char[]{'1','0','1','1','1'},
				new char[]{'1','1','1','1','1'},
				new char[]{'1','0','0','1','0'}
			}, 4
		);
	}
}