package leetcode;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WordBreak139
 *
 * @author naheon
 * @since 2018. 01. 03.
 */
public class WordBreak139 {
	Map<Character, List<String>> dict;
	Boolean[] cache;
	String str;

	public boolean wordBreak(String s, List<String> wordDict) {
		this.dict = new HashMap<>();
		for (char sc = 'a'; sc <= 'z'; sc++) {
			final String finalSc = sc + "";
			List<String> filterByAlphabet = wordDict.stream().filter(w -> w.startsWith(finalSc)).collect(toList());
			dict.put(sc, filterByAlphabet);
		}

		this.cache = new Boolean[s.length()];
		this.str = s;

		return canSplit(0);
	}

	private boolean canSplit(int index) {
		if (index >= str.length()) return true;
		else if (cache[index] != null) return cache[index];
		else if (!dict.containsKey(str.charAt(index))) return false;

		boolean result = false;
		String compare = str.substring(index);

		for (String d : dict.get(compare.charAt(0))) {
			if (!compare.startsWith(d)) continue;

			result = canSplit(index + d.length());
			if (result) break;
		}

		cache[index] = result;
		return result;
	}
}
