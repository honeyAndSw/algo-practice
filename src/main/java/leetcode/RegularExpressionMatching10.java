package leetcode;

/**
 * RegularExpressionMatching10
 */
public class RegularExpressionMatching10 {
	// '.' Matches any single character.
	// '*' Matches zero or more of the preceding element.
	public boolean isMatch(String s, String p) {
		return isMatch1(s, 0, p, 0);
	}

	/* Whether recursive solution is accepted, it's still reasonable to use cache. */
	private boolean isMatch1(String s, int si, String p, int pi) {
		/*
		 * If adding `si < s.length()` to `currentMatch`, rest of match will be done recursively.
		if (si >= s.length()) {
			// The rest of pattern should be ignorable,
			// which means every element has to be a pair with '*'.
			while (pi < p.length()) {
				if (pi >= p.length() - 1 || p.charAt(pi + 1) != '*') return false;
				pi += 2;
			}
			return true;
		}
		*/
		if (pi >= p.length()) return si >= s.length();

		boolean currentMatch = si < s.length() && (p.charAt(pi) == '.' || p.charAt(pi) == s.charAt(si));

		// Check next `si` if matched, stay in current `si` otherwise.
		if (pi < p.length() - 1 && p.charAt(pi + 1) == '*') {
			return (currentMatch && (isMatch1(s, si + 1, p, pi + 2) || isMatch1(s, si + 1, p, pi)))
					|| isMatch1(s, si, p, pi + 2);
		} else {
			return currentMatch && isMatch1(s, si + 1, p, pi + 1);
		}
	}

	/* Wrong Answer, because `*` is used as general wildcard that matches anything. */
	private boolean isMatch0(String s, int si, String p, int pi) {
		if (si >= s.length()) return pi <= p.length();
		if (pi >= p.length()) return false;
		// if (cache[si][pi] != -1) return cache[si][pi] == 1;

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

		// cache[si][pi] = result ? 1 : 0;
		return result;
	}
}
