package leetcode;

public class SumOfSquareNumbers633 {
	public boolean judgeSquareSum(int c) {
		int max = (int) Math.sqrt(c);
		for (int a = 0; a <= max; a++) {
			double b = Math.sqrt(c - (a*a));
			if (Math.floor(b) == b) return true;
			else max = (int) b;
		}
		return false;
	}
}
