package leetcode;

import java.util.*;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Roman_numerals">Roman Numerals</a>
 */
public class RomanToInteger13 {
	/**
	 * https://leetcode.com/problems/roman-to-integer/discuss/6529/
	 * 		My-solution-for-this-question-but-I-don't-know-is-there-any-easier-way
	 * 		#comment-7863
	 *
	 * I, II, III, IV, V, VI, VII, VIII, IX, X
	 * 1, 2,  3,   4,  5, 6,  7,   8,    9,  10
	 * Observation of 4 and 9 is that I only comes before V or X in subtractive notation.
	 * 10 to 100 follows the same rule:
	 * X, XX, XXX, XL, L, LX, LXX, LXXX, XC, C
	 * 10,20, 30,  40, 50,60, 70,  80,   90, 100
	 */
	public int romanToInt1(String s) {
		int res = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			switch (c) {
				case 'I':
					res += (res >= 5 ? -1 : 1);
					break;
				case 'V':
					res += 5;
					break;
				case 'X':
					res += 10 * (res >= 50 ? -1 : 1);
					break;
				case 'L':
					res += 50;
					break;
				case 'C':
					res += 100 * (res >= 500 ? -1 : 1);
					break;
				case 'D':
					res += 500;
					break;
				case 'M':
					res += 1000;
					break;
			}
		}
		return res;
	}

	public int romanToInt(String s) {
		String[] keys =  {"I","IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
		Integer[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

		Map<String, Integer> roman = new HashMap<>();
		for (int i = 0; i < keys.length; i++) {
			roman.put(keys[i], values[i]);
		}

		Set<String> subtractive = new HashSet<>();
		subtractive.addAll(Arrays.asList("I", "X", "C"));

		int accum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() - 1
				&& subtractive.contains(s.substring(i, i+1))
				&& roman.containsKey(s.substring(i, i+2))) {
				accum += roman.get(s.substring(i, i+2));
				i++;
			} else {
				accum += roman.get(s.substring(i, i+1));
			}
		}

		return accum;
	}
}
