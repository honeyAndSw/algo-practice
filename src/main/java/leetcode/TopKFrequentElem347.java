package leetcode;

import java.util.*;

public class TopKFrequentElem347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // O(n), where n = nums.length
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            int val = count.containsKey(n) ? count.get(n) : 0;
            count.put(n, val + 1);
        }

        /*
         * Implementation note: this implementation provides
         * O(log(n)) time for the enqueuing and dequeuing methods (offer, poll, remove and add);
         * linear time for the remove(Object) and contains(Object) methods;
         * and constant time for the retrieval methods (peek, element, and size).
         */
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> count.get(o2) - count.get(o1));

        for (Integer key : count.keySet()) {
            heap.add(key);
        }

        List<Integer> result = new LinkedList<>();
        while (k-- > 0) {
            result.add(heap.poll());
        }
        return result;
    }
}
