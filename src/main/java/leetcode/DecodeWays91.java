package leetcode;

import java.util.Arrays;

public class DecodeWays91 {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) return 0;

		int[] cache = new int[s.length()];
		Arrays.fill(cache, -1);
		return numDecodings(s, 0, cache);
	}

	private int numDecodings(String s, int i, int[] cache) {
		if (i == s.length()) return 1;
		if (cache[i] != -1) return cache[i];

		int dec1 = s.charAt(i) - '0';
		if (dec1 == 0) { // 0s are not allowed to be the first.
			cache[i] = 0;
		} else {
			cache[i] = numDecodings(s, i + 1, cache);

			if ((i < s.length() - 1) && ((dec1 * 10) + (s.charAt(i+1) - '0') <= 26)) {
				cache[i] += numDecodings(s, i + 2, cache);
			}
		}

		return cache[i];
	}
}
