package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringNoRepeat03 {

    public int lengthOfLongestSubstring5(String str) {
        int s = 0, e = 0, max = 0;
        Map<Character, Integer> position = new HashMap<>();

        while (e < str.length()) {
            char ch = str.charAt(e);

            if (position.containsKey(ch)) {
                s = position.get(ch) + 1;
            }

            max = Math.max(max, e - s + 1);
            position.put(ch, e++);
        }

        return max;
    }

    public int lengthOfLongestSubstring4(String str) {
        int s = 0, e = 0, max = 0;
        Map<Character, Integer> position = new HashMap<>();

        while (s < str.length() && e < str.length()) {
            char ch = str.charAt(e);

            if (position.containsKey(ch)) {
                position.remove(str.charAt(s++));
                // Better codes than solution #3.
                // Let while-loop move `s` and `e` one by one.
            } else {
                position.put(ch, e++);
                max = Math.max(max, position.size());
            }
        }

        return Math.max(max, position.size());
    }

    /* 69 ms */
    public int lengthOfLongestSubstring3(String str) {
        int s = 0, e = 0, max = 0;
        Map<String, Integer> position = new HashMap<>();

        while (s < str.length() && e < str.length()) {
            String ch = str.charAt(e) + "";
            if (position.containsKey(ch)) {
                // Check if substring from `s` to `e` is the new maximum.
                max = Math.max(max, position.size());

                // Move `s` to skip duplicated `ch`.
                int nextS = position.get(ch) + 1;
                while (s < nextS) {
                    position.remove(str.charAt(s++) + "");
                }
            }
            position.put(ch, e++);
        }

        return Math.max(max, position.size());
    }

    /* Accepted solution, still too late though. 125 ms */
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
