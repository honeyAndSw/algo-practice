package algostrategies.linearDataStructure18;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

/**
 * JosephusTest
 *
 * @author naheon
 * @since 2017. 12. 08.
 */
public class JosephusTest {
	@Test
	public void test_example1() throws Exception {
		LinkedList<Integer> lastTwo = Josephus.lastTwo(6, 3);
		assertArrayEquals(new Integer[]{3, 5}, lastTwo.toArray());
	}

	@Test
	public void test_example2() throws Exception {
		LinkedList<Integer> lastTwo = Josephus.lastTwo(40, 3);
		assertArrayEquals(new Integer[]{11, 26}, lastTwo.toArray());
	}
}