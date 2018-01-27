package leetcode;

public class ValidPalindrome125 {
	public boolean isPalindrome(String s) {
		int slow = 0;
		int fast = s.length() - 1;

		while (slow < fast) {
			if (!isAlphaNumeric(s.charAt(slow))) slow++;
			else if (!isAlphaNumeric(s.charAt(fast))) fast--;
			else if (Character.toLowerCase(s.charAt(slow)) == Character.toLowerCase(s.charAt(fast))) {
				slow++;
				fast--;
			} else return false;
		}

		return true;
	}

	public boolean isAlphaNumeric(char ch) {
		return Character.isAlphabetic(ch) || Character.isDigit(ch);
	}
}
