package leetcode;

public class HammingDistance461 {
	public int hammingDistance(int x, int y) {
		int xor = x ^ y;
		int count = 0;

		if (xor == 0) return count;

		int mask = 1;
		double len = Math.ceil(
			Math.max(Math.sqrt(x), Math.sqrt(y))
		);

		for (int i = 0; i <= len; i++) {
			if ((xor & mask) >= 1) count++;
			mask <<= 1;
		}

		return count;
	}
}
