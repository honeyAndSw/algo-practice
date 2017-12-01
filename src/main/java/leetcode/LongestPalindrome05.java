package leetcode;

/**
 * LongestPalindrome05
 */
public class LongestPalindrome05 {
	// Time Limit Exceeded.
	public String longestPalindrome(String s) {
		String longest = "";
		if (s == null) return longest;

		for (int start = 0; start < s.length(); start++) {
			for (int end = s.length() - 1; end >= start; end--) {
				if (s.charAt(start) != s.charAt(end)) continue;

				int s0 = start, e0 = end;
				while (s0 <= e0 && s.charAt(s0) == s.charAt(e0)) {
					s0++;
					e0--;
				}
				if (s0 > e0 && longest.length() < (end - start + 1)) {
					longest = s.substring(start, end + 1);
					if (longest.length() == s.length()) {
						// Return immediately because it's the best case.
						return longest;
					}
				}
			}
		}
		return longest;
	}
}
