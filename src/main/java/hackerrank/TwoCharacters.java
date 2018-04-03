package hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoCharacters {
	public int twoCharaters(String s) {
		// Initialization
		int LEN = 26;
		int[][] index = new int[LEN][LEN];
		int[][] count = new int[LEN][LEN];

		for (int i = 0; i < LEN; i++) {
			int[] rowI = new int[LEN];
			Arrays.fill(rowI, -1);
			index[i] = rowI;

			int[] rowC = new int[LEN];
			rowC[i] = -1; // ignore count[i][i]
			count[i] = rowC;
		}

		Set<Integer> unique = new HashSet<>();
		for (int si = 0; si < s.length(); si++) {
			char ch = s.charAt(si);
			int ci = ch - 'a';
			unique.add(ci);

			for (int i = 0; i < LEN; i++) {
				// Look at index[ch][?], (ch, ?)
				if (count[ci][i] >= 0 && (index[ci][i] == -1 || s.charAt(index[ci][i]) != ch)) {
					index[ci][i] = si;
					count[ci][i] += 1;
				} else {
					count[ci][i] = -1;
					count[i][ci] = -1;
				}

				// Look at index[?][ch], (?, ch)
				// index[i][ci] should be initialized before.
				if (index[i][ci] > -1) {
					if (count[i][ci] >= 0 && s.charAt(index[i][ci]) != ch) {
						index[i][ci] = si;
						count[i][ci] += 1;
					} else {
						count[i][ci] = -1;
						count[ci][i] = -1;
					}
				}
			}
		}

		// find max
		int max = 0;
		for (int i = 0; i < LEN; i++) {
			for (int j = 0; j < LEN; j++) {
				if (unique.contains(i) && unique.contains(j) && count[i][j] > max) {
					max = count[i][j];
				}
			}
		}
		return max;
	}
}
