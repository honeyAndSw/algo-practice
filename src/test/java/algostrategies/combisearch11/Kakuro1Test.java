package algostrategies.combisearch11;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Kakuro1Test
 *
 * @author naheon
 * @since 2017. 11. 15.
 */
public class Kakuro1Test {
	@Test
	public void test_makeHints() throws Exception {
		int[][][] hints = Kakuro1.makeHints(
			new int[][] {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 9, 7, 0, 0, 8, 7, 9},
				{0, 8, 9, 0, 8, 9, 5, 7},
				{0, 6, 8, 5, 9, 7, 0, 0},
				{0, 0, 6, 1, 0, 2, 6, 0},
				{0, 0, 0, 4, 6, 1, 3, 2},
				{0, 8, 9, 3, 1, 0, 1, 4},
				{0, 3, 1, 2, 0, 0, 2, 1}
			}
		);

		compareHints(hints, 2, 1, Kakuro1.HORIZONTAL, 16);
		compareHints(hints, 2, 5, Kakuro1.HORIZONTAL, 24);
		compareHints(hints, 3, 1, Kakuro1.HORIZONTAL, 17);
		compareHints(hints, 3, 4, Kakuro1.HORIZONTAL, 29);
		compareHints(hints, 4, 1, Kakuro1.HORIZONTAL, 35);
		compareHints(hints, 5, 2, Kakuro1.HORIZONTAL, 7);
		compareHints(hints, 5, 5, Kakuro1.HORIZONTAL, 8);
		compareHints(hints, 6, 3, Kakuro1.HORIZONTAL, 16);
		compareHints(hints, 7, 1, Kakuro1.HORIZONTAL, 21);
		compareHints(hints, 7, 6, Kakuro1.HORIZONTAL, 5);
		compareHints(hints, 8, 1, Kakuro1.HORIZONTAL, 6);
		compareHints(hints, 8, 6, Kakuro1.HORIZONTAL, 3);

		compareHints(hints, 1, 2, Kakuro1.VERTICAL, 23);
		compareHints(hints, 1, 3, Kakuro1.VERTICAL, 30);
		compareHints(hints, 1, 6, Kakuro1.VERTICAL, 27);
		compareHints(hints, 1, 7, Kakuro1.VERTICAL, 12);
		compareHints(hints, 1, 8, Kakuro1.VERTICAL, 16);
		compareHints(hints, 2, 5, Kakuro1.VERTICAL, 17);
		compareHints(hints, 3, 4, Kakuro1.VERTICAL, 15);
		compareHints(hints, 4, 7, Kakuro1.VERTICAL, 12);
		compareHints(hints, 5, 5, Kakuro1.VERTICAL, 7);
		compareHints(hints, 5, 8, Kakuro1.VERTICAL, 7);
		compareHints(hints, 6, 2, Kakuro1.VERTICAL, 11);
		compareHints(hints, 6, 3, Kakuro1.VERTICAL, 10);
	}

	public void compareHints(int[][][] hints, int yfrom1, int xfrom1, int direction, int expected) {
		assertEquals(expected, hints[yfrom1 - 1][xfrom1 - 1][direction]);
	}
}