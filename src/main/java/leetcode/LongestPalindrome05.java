package leetcode;

/**
 * LongestPalindrome05
 */
public class LongestPalindrome05 {
	public String longestPalindrome(String str) {
		if (str == null || str.length() <= 1) return str;

		int maxWindow = 0;
		String result = null;
		boolean[][] cache = new boolean[str.length()][str.length()];
		for (int i = 0; i < str.length(); i++) cache[i][i] = true;

		for (int w = 2; w <= str.length(); w++) {
			for (int s = 0; s <= str.length() - w; s++) {
				int e = s + w - 1;
				boolean isPalindrome = str.charAt(s) == str.charAt(e) && (w == 2 || (w > 2 && cache[s+1][e-1]));
				if (isPalindrome && maxWindow < w) {
					// It turns out that str#substring whenever finding palindrome affects time. :(
					maxWindow = w;
					result = str.substring(s, e + 1);
				}
				cache[s][e] = isPalindrome;
			}
		}

		return maxWindow == 0 ? str.charAt(0) + "" : result;
	}

	// Time Limit Exceeded. (94/94)
	public String longestPalindrome0(String s) {
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
