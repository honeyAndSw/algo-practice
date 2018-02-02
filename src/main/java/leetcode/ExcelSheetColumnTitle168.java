package leetcode;

public class ExcelSheetColumnTitle168 {
	public String convertToTitle(int n) {
		String[] alphabets = new String[]{
			"Z",
			"A", "B", "C", "D", "E", "F",
			"G", "H", "I", "J", "K", "L",
			"M", "N", "O", "P", "Q", "R",
			"S", "T", "U", "V", "W", "X",
			"Y"};

		String title = "";
		while (n-- > 0) {
			// title = alphabets[n % 26] + title;
			// When n = 26 + 26 (AZ), `n/26` becomes 2 that makes wrong answer.
			// int mod = n % 26;
			// n = mod == 0 ? (n - 26) / 26 : n / 26;
			title = (char)('A'+ (n % 26)) + title;
			n = n / 26;
		}
		return title;
	}
}
