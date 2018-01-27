package leetcode;

public class ValidPalindromeII680 {
	public boolean validPalindrome(String s) {
		return isValid(s, 0, s.length() - 1, true);
	}

	private boolean isValid(String s, int slow, int fast, boolean canSkip) {
		if (s.charAt(slow) != s.charAt(fast)) {
			return canSkip
				&& (isValid(s, slow + 1, fast, !canSkip) || isValid(s, slow, fast - 1, !canSkip));
		}

		while (slow <= fast && s.charAt(slow) == s.charAt(fast)) {
			slow++;
			fast--;
		}

		return (slow > fast) || isValid(s, slow, fast, canSkip);
	}
}
