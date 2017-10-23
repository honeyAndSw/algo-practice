package algostrategies.dptechnique09;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * DragonTest
 */
public class DragonTest {
	@Ignore
	@Test
	public void test_dragon0() throws Exception {
		Dragon.cache0.clear();
		assertEquals("FX", Dragon.dragon0(0, 1 - 1, 2));
		assertEquals("FX+YF", Dragon.dragon0(1, 1 - 1, 5));
		assertEquals("X+Y", Dragon.dragon0(1, 2 - 1, 3));
		assertEquals("+", Dragon.dragon0(1, 3, 1));
	}

	@Test
	public void test_dragon_skipAndGetOneChar() throws Exception {
		Dragon.setEvolveCache();
		assertEquals('F', Dragon.dragon("FX", 0, 0));
		assertEquals('X', Dragon.dragon("FX", 0, 1));

		// FX -> FX+YF
		assertEquals('X', Dragon.dragon("FX", 1, 1));
		assertEquals('+', Dragon.dragon("FX", 1, 2));

		// FX -> FX+YF -> FX+YF+FX-YF
		assertEquals('+', Dragon.dragon("FX", 2, 5));

		assertEquals('F', Dragon.dragon("FX", 42, 764853474));
	}

	@Test
	public void test_dragon() throws Exception {
		Dragon.setEvolveCache();
		assertEquals("FX", Dragon.dragon(0, 0, 2));
		assertEquals("FX+YF", Dragon.dragon(1, 0, 5));
		assertEquals("+FX-Y", Dragon.dragon(2, 5, 5));
		assertEquals("FX-YF-FX+YF+FX-YF-FX+YF-FX-YF-", Dragon.dragon(42, 764853474, 30));
	}

	@Test
	public void test_dragon_max() throws Exception {
		Dragon.dragon(50, 1000000000, 50);
	}
}