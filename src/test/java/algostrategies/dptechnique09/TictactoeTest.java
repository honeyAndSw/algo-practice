package algostrategies.dptechnique09;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TictactoeTest
 */
public class TictactoeTest {
	@Test
	public void test_examples() throws Exception {
		assertEquals("x", Tictactoe.canWin(new String[]{
			"xx.",
			"oo.",
			"..."
		}));
		assertEquals("o", Tictactoe.canWin(new String[]{
			"xox",
			"oo.",
			"x.x"
		}));
		assertEquals("TIE", Tictactoe.canWin(new String[]{
			"...",
			"...",
			"..."
		}));
	}

	@Test
	public void test_examples2() throws Exception {
		assertEquals("x", Tictactoe.canWin(new String[]{
			"xo.",
			"ox.",
			"..."
		}));
	}
}