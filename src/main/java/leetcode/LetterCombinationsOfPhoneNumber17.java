package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber17 {
	public List<String> letterCombinations(String digits) {
		List<String> extend = new LinkedList<>();
		int idx = 0;
		while (idx < digits.length()) {
			List<String> temp = new LinkedList<>();

			if (extend.size() == 0) {
				temp.addAll(letters(digits.charAt(idx)));
			} else {
				for (String letter : letters(digits.charAt(idx))) {
					for (String str : extend) {
						temp.add(str + letter);
					}
				}
			}

			extend = temp;
			idx++;
		}

		return extend;
	}

	private List<String> letters(char ch) {
		switch (ch) {
			case '2': return Arrays.asList("a", "b", "c");
			case '3': return Arrays.asList("d", "e", "f");
			case '4': return Arrays.asList("g", "h", "i");
			case '5': return Arrays.asList("j", "k", "l");
			case '6': return Arrays.asList("m", "n", "o");
			case '7': return Arrays.asList("p", "q", "r", "s");
			case '8': return Arrays.asList("t", "u", "v");
			case '9': return Arrays.asList("w", "x", "y", "z");
			default: return new ArrayList<>();
		}
	}
}
