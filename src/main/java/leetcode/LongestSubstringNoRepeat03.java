package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by honey.and.sw on 2017. 11. 25.
 */
public class LongestSubstringNoRepeat03 {

    /**
     * Accepted solution, still too late though.
     */
    public int lengthOfLongestSubstring2(String s) {
        int b = 0, e = 0, max = 0;
        Set<Character> cache = new HashSet<>();

        while (e < s.length()) {
            max = Math.max(max, e - b + 1);
            if (e < s.length()) {
                cache.add(s.charAt(e));
            }

            if (e + 1 < s.length() && cache.contains(s.charAt(e + 1))) {
                cache.clear();
                b++;
                e = b;
            } else {
                e++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int b = 0, e = 0, max = 0;
        while (e < s.length()) {
            max = Math.max(max, e - b + 1);
            if (e + 1 < s.length() &&
                s.substring(b, e + 1).contains(s.charAt(e + 1) + "")) {
                b++;
                e = b;
            } else {
                e++;
            }
        }
        return max;
    }
}
