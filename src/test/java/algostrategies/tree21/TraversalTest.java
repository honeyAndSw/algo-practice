package algostrategies.tree21;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TraversalTest
 *
 * @author naheon
 * @since 2018. 01. 10.
 */
public class TraversalTest {
	@Test
	public void test0() throws Exception {
		// 1
		Traversal.initialize(new int[]{1}, new int[]{1});
		assertEquals("1", Traversal.toPostOrder());
	}

	@Test
	public void test1() throws Exception {
		//   1
		// 2   3
		Traversal.initialize(new int[]{1,2,3}, new int[]{2,1,3});
		assertEquals("2 3 1", Traversal.toPostOrder());

		//   1
		// 2
		Traversal.initialize(new int[]{1,2}, new int[]{2,1});
		assertEquals("2 1", Traversal.toPostOrder());

		//   1
		//     3
		Traversal.initialize(new int[]{1,3}, new int[]{1,3});
		assertEquals("3 1", Traversal.toPostOrder());
	}

	@Test
	public void test2() throws Exception {
		Traversal.initialize(new int[]{27,16,9,12,54,36,72}, new int[]{9,12,16,27,36,54,72});
		assertEquals("12 9 16 36 72 54 27", Traversal.toPostOrder());

		Traversal.initialize(new int[]{409,479,10,838,150,441}, new int[]{409,10,479,150,838,441});
		assertEquals("10 150 441 838 479 409", Traversal.toPostOrder());
	}
}
