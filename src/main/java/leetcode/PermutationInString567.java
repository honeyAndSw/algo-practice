package leetcode;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by honey.and.sw on 2018. 1. 21.
 */
public class PermutationInString567 {

    /**
     * Return true if s2 contains the permutation of s1.
     * In other words, one of the first string's permutations is the substring of the second string.
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int N1 = s1.length();

        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Integer, Long> cache = s1.chars().boxed().collect(
                Collectors.groupingBy(ch -> ch, Collectors.counting())
        );

        // N1, s1's length, is the size of window.
        // Update `cache` in the first window.
        for (char ch : s2.substring(0, N1 - 1).toCharArray()) {
            minus(cache, ch);
        }

        // Move window to the right one by one.
        // 0 1 2 3 4 5 6 7 8 9
        // [wdw]
        //   [wdw]
        // minus : consume a character if exists in s1.
        // plus : add up a character if exists in s1.
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
