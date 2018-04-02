package leetcode;

import java.util.*;

public class TopKFrequentElem347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            int val = count.containsKey(n) ? count.get(n) : 0;
            count.put(n, val + 1);
        }

        // reversed
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
