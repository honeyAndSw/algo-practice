package algostrategies.greedy10;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

/**
 * StrJoinTest
 *
 * @author naheon
 * @since 2017. 11. 02.
 */
public class StrJoinTest {
	@Test
	public void test_examples() throws Exception {
		assertEquals(12,
				StrJoin.joinStr(new LinkedList<>(Arrays.asList(2, 2, 4)))
		);

		assertEquals(26,
				StrJoin.joinStr(new LinkedList<>(Arrays.asList(3, 1, 3, 4, 1)))
		);

		assertEquals(27,
				StrJoin.joinStr(new LinkedList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 2)))
		);
	}
}