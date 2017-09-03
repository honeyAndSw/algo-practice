package algostrategies.dp08;

import java.util.Arrays;

/**
 * Pi_bak
 *
 * @author naheon
 * @since 2017. 09. 04.
 */
public class Pi_bak {
	public static int grade(int[] seq) {
		int[] cache = new int[seq.length];
		Arrays.fill(cache, -1);

		int end = seq.length - 1;
		int start = end - 3;

		int grade = getGrade(seq, start+1, start+2, end);
		setCache(grade, cache, start, end);
		int total = grade;

		while (start >= 0) {
			int comp = cache[start + 1];
			boolean useSameGrade =
				(comp == 1 && seq[start] == seq[start + 1]) ||
					((comp == 2 || comp == 5) && (seq[start + 2] - seq[start + 1] == seq[start + 1] - seq[start])) ||
					(comp == 4 && seq[start] == seq[start + 2]) ||
					(comp == 10);
			// Even though it's possible to expand grade, the number of digits should be at most five.
			useSameGrade = (end - start < 5) && useSameGrade;

			if (useSameGrade) {
				// Continue to use the same one.
				cache[start] = comp;
				start--;
			} else {
				// Update start&end, rather than use grade 10.
				end = start;
				start = end - 3;

				grade = getGrade(seq, start+1, start+2, end);
				setCache(grade, cache, start, end);
				total += grade;
			}
		}

		return total;
	}

	private static void printCache(int[] cache) {
		StringBuffer sb = new StringBuffer("\n");

		for (int c : cache) {
			sb.append(c + ", ");
		}
		System.out.println(sb.append("\n").toString());
	}

	private static void setCache(int grade, int[] cache, int start, int end) {
		for (int i = Math.max(0, start); i <= Math.min(end, cache.length - 1); i++) {
			cache[i] = grade;
		}
	}

	private static int getGrade(int[] seq, int ai, int bi, int ci) {
		if (ci < 2) return 10;

		int diffAB = seq[ai] - seq[bi];
		int diffBC = seq[bi] - seq[ci];

		if (diffAB == 0 && diffBC == 0) return 1;
		else if (diffAB == diffBC) return (Math.abs(diffAB) == 1) ? 2 : 5;
		else if (-diffAB == diffBC) return 4;
		else return 10;
	}
}
