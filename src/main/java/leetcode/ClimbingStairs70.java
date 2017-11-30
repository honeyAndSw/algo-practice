package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by honey.and.sw on 2017. 11. 26.
 */
public class ClimbingStairs70 {
    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 2) return n;
        else if (cache.containsKey(n)) return cache.get(n);
        else {
            // It's similar to fibonacci number,
            // then we could make the question simple to fibonacci number calculation.
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            cache.put(n, result);
            return result;
        }
    }
}
