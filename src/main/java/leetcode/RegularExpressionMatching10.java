package leetcode;

import java.util.Arrays;

/**
 * RegularExpressionMatching10
 */
public class RegularExpressionMatching10 {
	int[][] cache;

	// '.' Matches any single character.
	// '*' Matches zero or more of the preceding element.
	public boolean isMatch(String s, String p) {
		int S = s.length();
		int P = p.length();
		cache = new int[S][P];
		for (int i = 0; i < S; i++) {
			int[] inner = new int[P];
			Arrays.fill(inner, -1);
			cache[i] = inner;
		}

		// return isMatch0(s, 0, p, 0);
		return isMatch1(s, 0, p, 0);
	}

	/* Wrong Answer, because `*` is used as general wildcard that matches anything. */
	private boolean isMatch0(String s, int si, String p, int pi) {
		if (si >= s.length()) return pi <= p.length();
		if (pi >= p.length()) return false;
		if (cache[si][pi] != -1) return cache[si][pi] == 1;

		char pattern = p.charAt(pi);
		boolean result;

		if (pattern == '.') {
			result = isMatch0(s, si + 1, p, pi + 1);
		} else if (pattern == '*') {
			boolean skip = isMatch0(s, si + 1, p, pi + 1);
			boolean skipZero = isMatch0(s, si + 1, p, pi);
			result = skip || skipZero;
		} else {
			result = pattern == s.charAt(si)
				? isMatch0(s, si + 1, p, pi + 1)
				: isMatch0(s, si, p, pi + 1);
		}

		cache[si][pi] = result ? 1 : 0;
		return result;
	}

	private boolean isMatch1(String s, int si, String p, int pi) {
		if (si >= s.length()) {
			// The rest of pattern should be ignorable,
			// which means every element has to be a pair with '*'.
			while (pi < p.length()) {
				if (pi >= p.length() - 1 || p.charAt(pi + 1) != '*') return false;
				pi += 2;
			}
			return true;
		}
		if (pi >= p.length()) return false;
		if (cache[si][pi] != -1) return cache[si][pi] == 1;

		char pattern = p.charAt(pi);
		char compare = s.charAt(si);
		boolean result;

		boolean currentMatch = (pattern == '.' || pattern == compare);

		if (pi < p.length() - 1 && p.charAt(pi + 1) == '*') {
			// Check next `si` if matched, stay in current `si` otherwise.
			result = (currentMatch && (isMatch1(s, si + 1, p, pi + 2) || isMatch1(s, si + 1, p, pi)))
					|| isMatch1(s, si, p, pi + 2);
		} else {
			result = currentMatch && isMatch1(s, si + 1, p, pi + 1);
		}

		cache[si][pi] = result ? 1 : 0;
		return result;
	}
}
