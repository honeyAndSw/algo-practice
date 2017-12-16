package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by honey.and.sw on 2017. 12. 16.
 */
public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();

        for (int n : nums) {
            Integer num = (Integer) n;
            int count = cache.containsKey(num) ? cache.get(num) + 1 : 1;
            if (count > Math.floorDiv(nums.length, 2)) {
                return num;
            } else {
                cache.put(num, count);
            }
        }

        return 0; // Never reach here.
    }
}
