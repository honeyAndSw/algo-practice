package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

/**
 * WordBreak139Test
 *
 * @author naheon
 * @since 2018. 01. 03.
 */
public class WordBreak139Test {
	WordBreak139 solution = new WordBreak139();

	@Test
	public void test0() throws Exception {
		assertTrue(solution.wordBreak("leetcode", Arrays.asList("leetcode")));
		assertTrue(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
		assertTrue(solution.wordBreak("leetcode", Arrays.asList("leet", "code", "java")));
		assertTrue(solution.wordBreak("leetcode", Arrays.asList("leet", "code", "leetcode")));

		assertFalse(solution.wordBreak("leetcode", Collections.emptyList()));
		assertFalse(solution.wordBreak("leetcode", Arrays.asList("leet")));
		assertFalse(solution.wordBreak("leetcode", Arrays.asList("code")));

		assertFalse(solution.wordBreak("leetcode", Arrays.asList("let", "code")));
	}
}