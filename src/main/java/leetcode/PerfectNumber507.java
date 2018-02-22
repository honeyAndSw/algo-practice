package leetcode;

public class PerfectNumber507 {
	public boolean checkPerfectNumber(int num) {
		int divisors = 0;
		int d0 = 1, d1 = (num / 2), d = d0;

		while (d <= d1) {
			if (num % d == 0) {
				if (d == 1) {
					divisors += d;
				} else {
					divisors += d + (num / d);
					d1 = (num / d) - 1;
				}
			}
			d++;
		}

		return num > 0 && num == divisors;
	}
}
