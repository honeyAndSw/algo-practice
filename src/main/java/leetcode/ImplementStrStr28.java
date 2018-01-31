package leetcode;

public class ImplementStrStr28 {
	public int strStr(String haystack, String needle) {
		int LEN = needle.length();
		for (int i = LEN - 1; i < haystack.length(); i++) {
			String window = haystack.substring(i - LEN + 1, i + 1);
			if (window.equals(needle)) {
				return i - LEN + 1;
			}
		}
		return -1;
	}
}
