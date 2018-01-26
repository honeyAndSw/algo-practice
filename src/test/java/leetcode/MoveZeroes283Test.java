package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * MoveZeroes283Test
 *
 * @author naheon
 * @since 2018. 01. 26.
 */
public class MoveZeroes283Test {
	MoveZeroes283 solution = new MoveZeroes283();

	@Test
	public void test0() throws Exception {
		int[] nums = new int[]{0,1,0,3,12};
		solution.moveZeroes(nums);
		assertArrayEquals(new int[]{1,3,12,0,0}, nums);
	}

	@Test
	public void test1() throws Exception {
		int[] nums = new int[0];
		solution.moveZeroes(nums);
		assertArrayEquals(new int[0], nums);
	}

	@Test
	public void test2() throws Exception {
		int[] nums = new int[]{1,3,12,0,0};
		solution.moveZeroes(nums);
		assertArrayEquals(new int[]{1,3,12,0,0}, nums);
	}

	@Test
	public void test3() throws Exception {
		int[] nums = new int[]{1,3,12};
		solution.moveZeroes(nums);
		assertArrayEquals(new int[]{1,3,12}, nums);
	}

	@Test
	public void test4() throws Exception {
		int[] nums = new int[]{0,0,0};
		solution.moveZeroes(nums);
		assertArrayEquals(new int[]{0,0,0}, nums);
	}

	@Test
	public void test5() throws Exception {
		int[] nums = new int[]{1};
		solution.moveZeroes(nums);
		assertArrayEquals(new int[]{1}, nums);
	}

	@Test
	public void test6() throws Exception {
		int[] nums = new int[]{0};
		solution.moveZeroes(nums);
		assertArrayEquals(new int[]{0}, nums);
	}
}