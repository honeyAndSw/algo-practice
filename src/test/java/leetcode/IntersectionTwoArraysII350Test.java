package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * IntersectionTwoArraysII350Test
 *
 * @author naheon
 * @since 2018. 01. 16.
 */
public class IntersectionTwoArraysII350Test {
	IntersectionTwoArraysII350 solution = new IntersectionTwoArraysII350();

	@Test
	public void test0() throws Exception {
		assertArrayEquals(new int[0], solution.intersect(new int[0], new int[0]));
		assertArrayEquals(new int[0], solution.intersect(new int[]{0}, new int[]{1}));

		assertArrayEquals(new int[]{0}, solution.intersect(new int[]{0}, new int[]{0}));
	}

	@Test
	public void test1() throws Exception {
		assertArrayEquals(new int[]{2,2}, solution.intersect(new int[]{1,2,2,1}, new int[]{2,2}));
		assertArrayEquals(new int[]{2,2}, solution.intersect(new int[]{1,2,2,1}, new int[]{2,2,2}));
	}
}