package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * IntersectionTwoArraysII350
 *
 * @author naheon
 * @since 2018. 01. 16.
 */
public class IntersectionTwoArraysII350 {

	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return intersect(nums2, nums1);
		}

		// Map<Integer, Integer> cache = new HashMap<>();
		// Arrays.stream(nums1).forEach(n1 ->
		// 	cache.put(n1, cache.containsKey(n1) ? cache.get(n1) + 1 : 1)
		// );
		Map<Integer, Long> cache = Arrays.stream(nums1).boxed()
			.collect(Collectors.groupingBy(n1 -> n1, Collectors.counting()));

		// List<Integer> result = new LinkedList<>();
		// Arrays.stream(nums2)
		// 	.filter(n2 -> cache.containsKey(n2))
		// 	.forEach(n2 -> {
		// 		Integer cached = cache.get(n2);
		// 		if (cached > 0) {
		// 			result.add(n2);
		// 			cache.put(n2, cached - 1);
		// 		}
		// 	});
		// return result.stream().mapToInt(i -> i).toArray();
		return Arrays.stream(nums2)
			.filter(n2 -> {
				if (!cache.containsKey(n2) || cache.get(n2) == 0) {
					return false;
				}
				cache.put(n2, cache.get(n2) - 1);
				return true;
			})
			.toArray();
	}
}
