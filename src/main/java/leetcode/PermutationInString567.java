package leetcode;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by honey.and.sw on 2018. 1. 21.
 */
public class PermutationInString567 {
    public boolean checkInclusion(String s1, String s2) {
        int N1 = s1.length();

        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Integer, Long> cache = s1.chars().boxed().collect(
                Collectors.groupingBy(ch -> ch, Collectors.counting())
        );

        for (char ch : s2.substring(0, N1 - 1).toCharArray()) {
            minus(cache, ch);
        }

        for (int i = N1 - 1; i < s2.length(); i++) {
            minus(cache, s2.charAt(i));
            if (allZero(cache)) {
                return true;
            }
            plus(cache, s2.charAt(i - N1 + 1));
        }

        return false;
    }

    private void minus(Map<Integer, Long> map, int key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) - 1);
        }
    }

    private void plus(Map<Integer, Long> map, int key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        }
    }

    private boolean allZero(Map<Integer, Long> map) {
        return map.values().stream().allMatch(i -> i == 0);
    }
}
