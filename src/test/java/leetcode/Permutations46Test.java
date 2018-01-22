package leetcode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

/**
 * Permutations46Test
 */
public class Permutations46Test {
	Permutations46 solution = new Permutations46();

	@Test
	public void test0() throws Exception {
		List<List<Integer>> result = solution.permute(new int[]{1,2,3});
		assertEquals(6, result.size());
	}

	@Test
	public void test1() throws Exception {
		List<List<Integer>> result = solution.permute(new int[]{0,-1,1});
		assertEquals(6, result.size());
	}
}
