package codility;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by honey.and.sw on 2017. 11. 30.
 */
public class PermCheck {
    public int solution(int[] A) {
        Set<Integer> cache = new HashSet<>();
        int max = 0, min = 1000000000 + 1;

        for (int A0 : A) {
            min = Math.min(min, A0);
            max = Math.max(max, A0);
            cache.add(A0);
        }

        return (min == 1 && max == A.length && cache.size() == A.length) ? 1 : 0;
    }
}
