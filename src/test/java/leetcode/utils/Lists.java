package leetcode.utils;

import java.util.List;

public class Lists {
	public static int[] toArray(List<Integer> list) {
		return list.stream().mapToInt(i -> i).toArray();
	}
}
