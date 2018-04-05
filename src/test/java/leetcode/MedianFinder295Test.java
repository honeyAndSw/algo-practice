package leetcode;

import static leetcode.MedianFinder295.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/**
 * MedianFinder295Test
 *
 * @author naheon
 * @since 2018. 04. 05.
 */
public class MedianFinder295Test {

	@Test
	public void testName() throws Exception {
		MedianFinder295 solution = new MedianFinder295();

		solution.addNum(1);
		solution.addNum(2);
		assertEquals(1.5, solution.findMedian(), 0.0);
	}

	@Test
	public void test_binarySearch() throws Exception {
		assertEquals(0, findInsertPos(new ArrayList<>(), 0));
		assertEquals(1, findInsertPos(Arrays.asList(1), 2));
	}

	@Test
	public void test_binarySearch_same() throws Exception {
		assertEquals(0, findInsertPos(Arrays.asList(1,2,3), 1));
		assertEquals(1, findInsertPos(Arrays.asList(1,2,3), 2));
		assertEquals(2, findInsertPos(Arrays.asList(1,2,3), 3));

		assertEquals(0, findInsertPos(Arrays.asList(1,2,2,3), 1));
		assertEquals(1, findInsertPos(Arrays.asList(1,2,2,3), 2));
		assertEquals(3, findInsertPos(Arrays.asList(1,2,2,3), 3));
	}

	@Test
	public void test_binarySearch_not_exists() throws Exception {
		assertEquals(0, findInsertPos(Arrays.asList(1,2,5), 0));
		assertEquals(2, findInsertPos(Arrays.asList(1,2,5), 3));
		assertEquals(2, findInsertPos(Arrays.asList(1,2,5), 4));
		assertEquals(3, findInsertPos(Arrays.asList(1,2,5), 6));

		assertEquals(0, findInsertPos(Arrays.asList(1,3,5,7), 0));
		assertEquals(1, findInsertPos(Arrays.asList(1,3,5,7), 2));
		assertEquals(2, findInsertPos(Arrays.asList(1,3,5,7), 4));
		assertEquals(3, findInsertPos(Arrays.asList(1,3,5,7), 6));
		assertEquals(4, findInsertPos(Arrays.asList(1,3,5,7), 8));
	}

}