package algostrategies.dptechnique09;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * NumberGameTest
 *
 * @author naheon
 * @since 2017. 10. 26.
 */
public class NumberGameTest {
	@Test
	public void test_examples() throws Exception {
		NumberGame.cache.clear();
		assertEquals(-1000, NumberGame.moreScore(new int[]{-1000, -1000, -3, -1000, -1000}, 0, 4, 0));

		NumberGame.cache.clear();
		assertEquals(1100, NumberGame.moreScore(new int[]{100, -1000, -1000, 100, -1000, -1000}, 0, 5, 0));

		NumberGame.cache.clear();
		assertEquals(7, NumberGame.moreScore(new int[]{7, -5, 8, 5, 1, -4, -8, 6, 7, 9}, 0, 9, 0));
	}
}