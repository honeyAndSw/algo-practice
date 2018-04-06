package leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

public class DeleteOptTwoStrs583Test {
	DeleteOptTwoStrs583 solution = new DeleteOptTwoStrs583();

	@Test
	public void test_combination0() throws Exception {
		String s = "sea";
		boolean[] use = new boolean[s.length()];

		Set<String> result = solution.combinations(s, s.length(), use, 0);
		assertEquals(1, result.size());
	}

	@Test
	public void test_combination1() throws Exception {
		String s = "sea";
		boolean[] use = new boolean[s.length()];

		Set<String> result = solution.combinations(s, 2, use, 0);
		assertEquals(3, result.size());

		assertTrue(result.contains("ea"));
		assertTrue(result.contains("sa"));
		assertTrue(result.contains("se"));
	}

	@Test
	public void test_combination2() throws Exception {
		Set<String> result = solution.combinations("sea", 1, new boolean[3], 0);
		assertEquals(3, result.size());
	}

	@Test
	public void test_minDistance0() throws Exception {
		assertEquals(2, solution.minDistance("sea", "eat"));
		assertEquals(2, solution.minDistance("esa", "eat"));
		assertEquals(2, solution.minDistance("esa", "tea"));
		assertEquals(4, solution.minDistance("esab", "eatc"));
	}

	@Test
	public void test_minDistance1() throws Exception {
		assertEquals(3, solution.minDistance("seac", "eat"));
		assertEquals(3, solution.minDistance("sea", "eatc"));
	}

	@Test
	public void test_minDistance2() throws Exception {
		solution.minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine");
		solution.minDistance("dinitrophenylhydrazine", "benzalphenylhydrazone");
	}
}