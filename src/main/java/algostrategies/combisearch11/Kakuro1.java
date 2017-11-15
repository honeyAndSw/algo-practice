package algostrategies.combisearch11;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Kakuro1
 *
 * @author naheon
 * @since 2017. 11. 15.
 */
public class Kakuro1 {

	public static final int VERTICAL = 1;
	public static final int HORIZONTAL = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		System.out.println(cases);

		for (int c = 0; c < cases; c++) {
			int len = scanner.nextInt();
			int[][] answer = new int[len][len];
			for (int y = 0; y < len; y++) {
				for (int x = 0; x < len; x++) {
					answer[y][x] = scanner.nextInt();
				}
			}

			System.out.println(makeQuestions(answer));
		}
	}

	public static String makeQuestions(int[][] answer) {
		int len = answer.length;

		StringBuilder questionSb = new StringBuilder();
		questionSb.append(len + "\n");

		IntStream.range(0, len).forEachOrdered(y -> {
			IntStream.range(0, len).forEachOrdered(x ->
				questionSb.append(answer[y][x] > 0 ? 1 : 0).append(" ")
			);
			questionSb.append("\n");
		});

		int[][][] hints = makeHints(answer);
		int hintCount = 0;
		StringBuilder horizonHintSb = new StringBuilder();
		StringBuilder verticalHintSb = new StringBuilder();

		for (int y = 0; y < len; y++) {
			for (int x = 0; x < len; x++) {
				if (hints[y][x][HORIZONTAL] > 0) {
					hintCount++;
					horizonHintSb
						.append(y + 1).append(" ").append(x + 1).append(" ")
						.append(0).append(" ")
						.append(hints[y][x][HORIZONTAL]).append("\n");
				}

				if (hints[y][x][VERTICAL] > 0) {
					hintCount++;
					verticalHintSb
						.append(y + 1).append(" ").append(x + 1).append(" ")
						.append(1).append(" ")
						.append(hints[y][x][VERTICAL]).append("\n");
				}
			}
		}

		questionSb.append(hintCount)
				.append("\n")
				.append(horizonHintSb.toString())
				.append(verticalHintSb.toString());

		return questionSb.toString();
	}

	/**
	 * 0s denote black or hint cells, and positive integers denote white cells.
	 * @param answer
	 */
	public static int[][][] makeHints(int[][] answer) {
		int len = answer.length;
		int[][][] hints = new int[len][len][2];

		// Fill horizontal hints.
		for (int y = 0; y < len; y++) {
			int hint = 0;
			boolean adjoint = false;

			for (int x = len - 1; x >= 0; x--) {
				if (answer[y][x] > 0) { // white cell. Build a horizontal hint.
					hint += answer[y][x];
					if (!adjoint) adjoint = true;
				} else if (adjoint) { // There's built hint right before this cell.
					hints[y][x][HORIZONTAL] = hint;
					hint = 0;
					adjoint = false;
				}
			}
		}

		// Fill vertical hints.
		for (int x = 0; x < len; x++) {
			int hint = 0;
			boolean adjoint = false;

			for (int y = len - 1; y >= 0; y--) {
				if (answer[y][x] > 0) { // white cell. Build a horizontal hint.
					hint += answer[y][x];
					if (!adjoint) adjoint = true;
				} else if (adjoint) { // There's built hint right before this cell.
					hints[y][x][VERTICAL] = hint;
					hint = 0;
					adjoint = false;
				}
			}

		}

		return hints;
	}
}
