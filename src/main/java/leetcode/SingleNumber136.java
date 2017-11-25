package leetcode;

import java.util.LinkedList;

/**
 * Created by honey.and.sw on 2017. 11. 23.
 */
public class SingleNumber136 {

    /**
     * More simple solution than #1 using cache
     */
    public int singleNumber2(int[] nums) {
        LinkedList<Integer> cache = new LinkedList<>();
        for (int n : nums) {
            // If use `int n` directly,
            // LinkedList#remove(int n) will be called where n is index.
            // LinkedList#remove(Object o) is what to delete `o`.
            Integer in = n;
            if (cache.contains(in)) cache.remove(in);
            else cache.add(in);
        }
        return cache.get(0);
    }

    public int singleNumber(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        int[] flags = new int[max - min + 1];
        for (int n : nums) {
            int idx = 0 - min + n;
            flags[idx]++;
        }
        for (int n : nums) {
            int idx = 0 - min + n;
            if (flags[idx] == 1) return n;
        }
        return -1; // never reach here.
    }
}
