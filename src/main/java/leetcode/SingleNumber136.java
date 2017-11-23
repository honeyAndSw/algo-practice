package leetcode;

/**
 * Created by honey.and.sw on 2017. 11. 23.
 */
public class SingleNumber136 {
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
