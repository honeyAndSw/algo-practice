package algostrategies.heap23;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class RunningMedianTest {
	@Test
	public void test0() throws Exception {
		runningMedian(new int[]{3}, new int[]{3});
		runningMedian(new int[]{3,1}, new int[]{3,1});

		runningMedian(
			new int[]{3,1,5,4,2},
			new int[]{3,1,3,3,3}
		);
	}

	private void runningMedian(int[] nums, int[] medians) {
		PriorityQueue<Long> max = RunningMedian.createMaxHeap();
		PriorityQueue<Long> min = RunningMedian.createMinHeap();

		for (int i = 0; i < nums.length; i++) {
			assertEquals(medians[i], RunningMedian.nextMedian(max, min, nums[i]));
		}
	}
}