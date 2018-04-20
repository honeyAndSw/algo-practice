package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * MinGeneticMutation433Test
 *
 * @author naheon
 * @since 2018. 04. 20.
 */
public class MinGeneticMutation433Test {
	MinGeneticMutation433 solution = new MinGeneticMutation433();

	@Test
	public void test0() throws Exception {
		assertEquals(1, solution.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
		assertEquals(2, solution.minMutation("AACCGGTT", "AAACGGTA",
			new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}
		));
		assertEquals(3, solution.minMutation("AAAAACCC", "AACCCCCC",
			new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}
		));
	}

	@Test
	public void test1() throws Exception {
		assertEquals(-1, solution.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AACCCCCC"}));
	}

	@Test
	public void test2() throws Exception {
		assertEquals(-1, solution.minMutation("AACCGGTT", "AACCGGTA", new String[0]));
		assertEquals(-1, solution.minMutation("AAAAAAAA", "CCCCCCCC",
			new String[]{"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA"}
		));
		assertEquals(1, solution.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
	}

	@Test
	public void test3() throws Exception {
		assertEquals(4, solution.minMutation(
			"AACCGGTT",
			"AAACGGTA",
			new String[]{"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"}
		));
	}
}