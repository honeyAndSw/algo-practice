package leetcode;

public class PerfectNumber507 {
	public boolean checkPerfectNumber2(int num) {
		int divisors = 0;
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				divisors += i;
				if (i * i != num) {
					divisors += num / i;
				}
			}
		}

		return divisors - num == num;
	}

	public boolean checkPerfectNumber(int num) {
		int divisors = 1;
		int start = 2, end = num / 2;
		while (start <= end) {
			if (num % start == 0) {
				divisors += start + (num / start);
				end = (num / start) - 1;
			}

			start++;
		}

		return num > 1 && num == divisors;
	}
}
