package leetcode;

import java.util.HashSet;
import java.util.Set;

public class DeleteOptTwoStrs583 {

	/*
	 * Time Limit Exceeded (25/1307): Combinations on `len` are re-calculated from the longest `len`.
	 * Time Limit Exceeded (26/1307): Make combinations for one of them, not both.
	 * Time Limit Exceeded (37/1307)
	 */
	public int minDistance(String word1, String word2) {
		if (word1.length() > word2.length()) {
			return minDistance(word2, word1);
		}

		int len = Math.min(word1.length(), word2.length());
		Set<String> combi1 = new HashSet<>();
		combi1.add(word1);

		while (len > 0) {
			Set<String> temp1 = new HashSet<>();
			for (String c1 : combi1) temp1.addAll(combinations(c1, len, new boolean[word1.length()], 0));

			for (String t1 : temp1) {
				if (contains(word2, t1)) {
					return (word1.length() - len) + (word2.length() - len);
				}
			}

			len--;
			combi1 = temp1;
		}

		return word1.length() + word2.length();
	}

	boolean contains(String word, String comp) {
		int w = 0, c = 0;
		while (w < word.length() && c < comp.length()) {
			if (word.charAt(w) == comp.charAt(c)) {
				c++;
			}
			w++;
		}
		return c == comp.length();
	}

	/**
	 * @param word
	 * @param len the length of combinations
	 * @param delete array of flags that has the same length of word, false if a char is removed.
	 * @param deleted the number of chars deleted so far
	 * @return
	 */
	Set<String> combinations(String word, int len, boolean[] delete, int deleted) {
		if (word.length() - deleted == len) {
			String ret = "";
			for (int i = 0; i < word.length(); i++) {
				if (!delete[i]) ret += word.charAt(i);
			}
			Set<String> wrap = new HashSet<>();
			wrap.add(ret);
			return wrap;
		}

		Set<String> accum = new HashSet<>();
		for (int i = 0; i < word.length(); i++) {
			if (delete[i]) continue;

			delete[i] = true;
			Set<String> recursive = combinations(word, len, delete, deleted + 1);
			if (recursive.size() > 0) {
				accum.addAll(recursive);
			}
			delete[i] = false;
		}

		return accum;
	}
}
