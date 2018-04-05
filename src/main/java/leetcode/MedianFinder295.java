package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * MedianFinder295
 *
 * @author naheon
 * @since 2018. 04. 05.
 */
public class MedianFinder295 {
	List<Integer> sortedList;

	/** initialize your data structure here. */
	public MedianFinder295() {
		sortedList = new ArrayList<>();
	}

	public void addNum(int num) {
		int index = findInsertPos(sortedList, num);
		sortedList.add(index, num);
	}

	public double findMedian() {
		int len = sortedList.size();
		int mid = len / 2;

		if (len % 2 == 1) return sortedList.get(mid);
		return (sortedList.get(mid) + sortedList.get(mid - 1)) / 2.0;
	}

	/* Returns an index to insert val, assuming that insertion shifts left. */
	public static int findInsertPos(List<Integer> list, int val) {
		return findInsertPos(list, val, 0, list.size());
	}

	/* https://gist.github.com/anizzomc/11390613 */
	private static int findInsertPos(List<Integer> list, int val, int start, int end) {
		if (start >= end) return start;

		int mid = (start + end) / 2;
		if (list.get(mid) >= val) return findInsertPos(list, val, start, mid);
		else return findInsertPos(list, val, mid + 1, end);
	}
}
