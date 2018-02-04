package leetcode;

public class MultiplyStrings43 {
	public String multiply(String num1, String num2) {
		if (num1.length() < num2.length()) return multiply(num2, num1);

		String accum = "";
		for (int i = 0; i < num2.length(); i++) {
			String m = multiplyOne(num1, num2.charAt(i));
			m = appendZeroes(m, num2.length() - 1 - i);
			accum = accum.length() == 0 ? m : sum(accum, m);
		}

		return accum;
	}

	private String multiplyOne(String num1, char n2) {
		if (n2 == '0') return "0";

		String result = "";
		int carry = 0;
		for (int i = num1.length() - 1; i >= 0; i--) {
			int m = (num1.charAt(i) - '0') * (n2 - '0') + carry;
			result = (m % 10) + result;
			carry = m / 10;
		}

		return carry > 0 ? carry + result : result;
	}

	private String appendZeroes(String s, int i) {
		while (i-- > 0) s = s + "0";
		return s;
	}

	private String sum(String num1, String num2) {
		String result = "";
		int carry = 0;
		int p1 = num1.length() - 1, p2 = num2.length() - 1;

		while (p1 >= 0) {
			int m = carry + (num1.charAt(p1) - '0') + (p2 >= 0 ? num2.charAt(p2) - '0' : 0);
			result = (m % 10) + result;
			carry = m / 10;
			p1--;
			p2--;
		}

		return carry > 0 ? carry + result : result;
	}
}
