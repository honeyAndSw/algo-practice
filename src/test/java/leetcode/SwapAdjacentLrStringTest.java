package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * SwapAdjacentLrStringTest
 *
 * @author naheon
 * @since 2018. 04. 02.
 */
public class SwapAdjacentLrStringTest {
	SwapAdjacentLrString solution = new SwapAdjacentLrString();

	@Test
	public void test1() throws Exception {
		// XXR XL XR XXX
		// XXR LX
		assertEquals("XXXRLXXXXR", solution.sort("XXRXLXRXXX"));

		// assertTrue(solution.canTransform("RXXLRXRXL", "XRLXXRRLX"));
		// assertTrue(solution.canTransform("XXRXLXRXXX", "XXRLXXXXXR"));
	}

	@Test
	public void test_sort() throws Exception {
		// RXXL RXR XL
		// XXRL XRR LX
		assertEquals("XXRLXRRLX", solution.sort("RXXLRXRXL"));
		assertEquals("XXXR", solution.sort("RXXX"));
	}
}