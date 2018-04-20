package leetcode;

/**
 * MinGeneticMutation433
 *
 * @author naheon
 * @since 2018. 04. 20.
 */
public class MinGeneticMutation433 {
	public int minMutation(String start, String end, String[] bank) {
		// row: bank, col: length of strings
		boolean[][] diff = new boolean[bank.length][start.length()];
		int bankEndIdx = -1;
		int endTotallDiff = 0;

		for (int bi = 0; bi < bank.length; bi++) {
			String b = bank[bi];
			if (b.equals(end)) bankEndIdx = bi;

			for (int i = 0; i < b.length(); i++) {
				if (start.charAt(i) != b.charAt(i)) {
					diff[bi][i] = true;
					if (b.equals(end)) endTotallDiff++;
				}
			}
		}

		if (bankEndIdx == -1) return -1;
		if (endTotallDiff == 1) return endTotallDiff;

		int mut = 0;
		boolean[] endDiff = diff[bankEndIdx];
		for (int ci = 0; ci < start.length(); ci++) {
			if (!endDiff[ci]) continue;

			for (int bi = 0; bi < bank.length; bi++) {
				if (bi != bankEndIdx && diff[bi][ci]) {
					mut++;
					break;
				}
			}
		}

		return endTotallDiff - mut <= 1 ? mut + 1 : -1;
	}
}
