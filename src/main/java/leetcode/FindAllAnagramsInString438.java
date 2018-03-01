package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInString438 {
	public List<Integer> findAnagrams(String s, String p) {
		int[] sChars = new int[26];
		int[] pChars = new int[26];

		for (char chp : p.toCharArray()) pChars[chp - 'a'] += 1;

		List<Integer> result = new LinkedList<>();
		int windowSize = p.length();
		for (int i = 0; i <= s.length() - windowSize; i++) {
			if (i == 0) {
				// Initialize window for `s` for the first time.
				for (char chs : s.substring(0, windowSize).toCharArray()) {
					sChars[chs - 'a'] += 1;
				}
			} else {
				// Update window for `s`
				sChars[s.charAt(i-1) - 'a'] -= 1; // previous window
				sChars[s.charAt(i + windowSize - 1) - 'a'] += 1; // new window
			}

			if (Arrays.equals(sChars, pChars)) {
				result.add(i);
			}
		}

		return result;
	}
}
