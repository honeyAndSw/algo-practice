package leetcode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CombinationSum39Test {
	CombinationSum39 solution = new CombinationSum39();

	@Test
	public void test0() throws Exception {
		List<List<Integer>> list = solution.combinationSum(new int[]{1}, 1);
		assertEquals(1, list.size());
		assertArrayEquals(new int[]{1}, toUnboxedArray(list.get(0)));
	}

	@Test
	public void test1() throws Exception {
		List<List<Integer>> list = solution.combinationSum(new int[]{1}, 3);
		assertEquals(1, list.size());
		assertArrayEquals(new int[]{1,1,1}, toUnboxedArray(list.get(0)));
	}

	@Test
	public void test2() throws Exception {
		List<List<Integer>> list = solution.combinationSum(new int[0], 10);
		assertEquals(0, list.size());
	}

	@Test
	public void test3() throws Exception {
		List<List<Integer>> list = solution.combinationSum(new int[]{2,3,4,6,7}, 7);
		assertEquals(3, list.size());
		assertArrayEquals(new int[]{2,2,3}, toUnboxedArray(list.get(0)));
		assertArrayEquals(new int[]{3,4}, toUnboxedArray(list.get(1)));
		assertArrayEquals(new int[]{7}, toUnboxedArray(list.get(2)));
	}

	private int[] toUnboxedArray(List<Integer> list) {
		return list.stream().mapToInt(i -> i).toArray();
	}
}