package algostrategies.tree21;

import static org.junit.Assert.*;

import java.util.Arrays;

import algostrategies.tree21.Fortress.Circle;
import algostrategies.tree21.Fortress.Wall;
import org.junit.Test;

/**
 * FortressTest
 *
 * @author naheon
 * @since 2018. 01. 11.
 */
public class FortressTest {
	@Test
	public void test_Circle_contains() throws Exception {
		assertTrue(new Circle(21, 15, 20).contains(new Circle(15, 15, 10)));
		assertFalse(new Circle(5, 5, 5).contains(new Circle(10, 5, 5)));
	}

	@Test
	public void test_Wall_append1() throws Exception {
		Wall outermost = new Wall(new Circle(10, 10, 10));
		outermost.append(new Circle(5, 5, 5));

		assertEquals(1, outermost.walls.size());
		assertEquals(1, outermost.maxInnerWallCount);
	}

	@Test
	public void test_Wall_append2() throws Exception {
		Wall outermost = new Wall(new Circle(10, 0, 10));
		outermost.append(new Circle(5, 0, 5));
		outermost.append(new Circle(15, 0, 5));

		assertEquals(2, outermost.walls.size());
		assertEquals(1, outermost.maxInnerWallCount);
	}

	@Test
	public void test_countMaxWall0() throws Exception {
		Wall outermost = construct(new int[][]{
			{5,5,15},
			{5,5,10}, {5,5,5}
		});

		assertEquals(1, outermost.walls.size());
		assertEquals(2, outermost.maxInnerWallCount);

		assertEquals(2, Fortress.countMaxWall(outermost));
	}

	@Test
	public void test_countMaxWall1() throws Exception {
		Wall outermost = construct(new int[][]{
			{21,15,20},
			{15,15,10}, {13,12,5}, {12,12,3}, {19,19,2}, {30,24,5}, {32,10,7}, {32,9,4}
		});

		assertEquals(5, Fortress.countMaxWall(outermost));
	}

	@Test
	public void test_countMaxWall2() throws Exception {
		Wall outermost = construct(new int[][]{
			{10,0,10}, {5,0,5}, {15,0,5}
		});

		assertEquals(2, Fortress.countMaxWall(outermost));
	}

	@Test
	public void test_countMaxWall3() throws Exception {
		Wall outermost = construct(new int[][]{{10,0,10}});
		assertEquals(0, Fortress.countMaxWall(outermost));
	}

	private Wall construct(int[][] circles) {
		int[] first = circles[0];
		Wall outermost = new Wall(new Circle(first[0],first[1],first[2]));

		Arrays.stream(circles)
			.skip(1)
			.forEach(c -> outermost.append(new Circle(c[0], c[1], c[2])));

		return outermost;
	}
}
