package leetcode;

public abstract class FirstBadVersion278 {
	abstract boolean isBadVersion(int n);

	public int firstBadVersion(int n) {
		// Stack Overflow on very big `n`
		// return firstBadVersion(1, n);

		long s = 1, e = n;
		while (s < e) {
			long m = (s + e) / 2;
			if (isBadVersion((int) m)) e = m;
			else s = m + 1;
		}
		return (int) s;
	}

	private int firstBadVersion(int s, int e) {
		if (s > e) return -1;

		int m = (s + e) / 2;
		if (isBadVersion(m)) {
			int before = firstBadVersion(s, m-1);
			return before == -1 ? m : before;
		}
		return firstBadVersion(m+1, e);
	}
}
