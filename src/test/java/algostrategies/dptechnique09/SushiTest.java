package algostrategies.dptechnique09;

import static algostrategies.dptechnique09.Sushi.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * SushiTest
 *
 * @author honey.and.sw
 * @since 2017. 10. 26.
 */
public class SushiTest {
	@Test
	public void test_example1() throws Exception {
	//		6 10000
	//		2500 7
	//		3000 9
	//		4000 10
	//		5000 12
	//		10000 20
	//		15000 1
		Problem problem = new Problem(
				new int[]{2500, 3000, 4000, 5000, 10000, 15000},
				new int[]{7, 9, 10, 12, 20, 1});

		assertEquals(28, problem.solve(0, 10000));
		// System.out.println(problem.solve(0, 2147483647));
	}

	@Test
	public void test_example2() throws Exception {
	//	6 543975612
	//	2500 7
	//	3000 9
	//	4000 10
	//	5000 12
	//	10000 20
	//	15000 1
		Problem problem = new Problem(
				new int[]{2500, 3000, 4000, 5000, 10000, 15000},
				new int[]{7, 9, 10, 12, 20, 1});

		assertEquals(1631925, problem.solve(0, 543975612));
	}

	@Test
	public void testName() throws Exception {
		Problem problem = new Problem(
				new int[]{25, 30, 40, 50, 100, 150},
				new int[]{7, 9, 10, 12, 20, 1});

		assertEquals(1631925, problem.solve(0, 5439756));


	}
}