package algostrategies.stack19;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Brackets2Test
 *
 * @author naheon
 * @since 2017. 12. 08.
 */
public class Brackets2Test {
	@Test
	public void test0() throws Exception {
		assertTrue(Brackets2.match("()"));

		assertFalse(Brackets2.match("("));
		assertFalse(Brackets2.match("(("));
		assertFalse(Brackets2.match("(()"));
		assertFalse(Brackets2.match(")"));
		assertFalse(Brackets2.match("))"));
	}

	@Test
	public void test1() throws Exception {
		assertTrue(Brackets2.match("()()"));
		assertTrue(Brackets2.match("([])"));
		assertFalse(Brackets2.match("([)"));
		assertFalse(Brackets2.match("(])"));

		assertFalse(Brackets2.match("({[}])"));
		assertTrue(Brackets2.match("({}[(){}])"));
	}

	@Test
	public void test2() throws Exception {
		assertFalse(Brackets2.match("({][(){}])"));
		assertFalse(Brackets2.match("[(])"));
	}

	@Test
	public void test3() throws Exception {
		assertFalse(Brackets2.match(")("));
		assertFalse(Brackets2.match("[)(]"));
		assertFalse(Brackets2.match("}{)(]["));
	}

	@Test
	public void test4() throws Exception {
		assertTrue(Brackets2.match("((())())"));
	}

	@Test
	public void test5() throws Exception {
		assertFalse(Brackets2.match("())"));
	}
}