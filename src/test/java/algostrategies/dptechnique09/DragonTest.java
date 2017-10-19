package algostrategies.dptechnique09;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * DragonTest
 */
public class DragonTest {
	@Test
	public void test_age0() throws Exception {
		Dragon.cache0.clear();
		assertEquals("FX", Dragon.dragon0(0, 1 - 1, 2));
//		p = 764853475;
//		i = 30;
//		assertEquals("FX-YF-FX+YF+FX-YF-FX+YF-FX-YF-", Dragon.dragon0(42).substring(p - 1, p - 1 + i));
	}

	@Test
	public void test_age1() throws Exception {
		Dragon.cache0.clear();
//		assertEquals("FX+YF", Dragon.dragon0(1, 1 - 1, 5));
		assertEquals("X+Y", Dragon.dragon0(1, 2 - 1, 3));
//		assertEquals("+", Dragon.dragon0(1, 3, 1));
	}
}