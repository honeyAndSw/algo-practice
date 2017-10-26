package algostrategies.dptechnique09;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * NumberGame
 *
 * @author honey.and.sw
 * @since 2017. 10. 26.
 */
public class NumberGame {

	public static Map<String, Integer> cache = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while (cases-- > 0) {
			cache.clear();

			int len = sc.nextInt();
			int[] board = new int[len];
			for (int l = 0; l < len; l++) {
				board[l] = sc.nextInt();
			}
			System.out.println(moreScore(board, 0, len - 1, 0));
		}
	}

	public static int moreScore(int[] board, int left, int right, int turn) {
		if (left == right) return board[left];
		else if (left > right) return 0;

		String cacheKey = left + ":" + right;
		if (cache.containsKey(cacheKey)) return cache.get(cacheKey);

		int takeLeft = board[left] - moreScore(board, left + 1, right, 1 - turn);
		int takeRight = board[right] - moreScore(board, left, right - 1, 1 - turn);
		int skipLeft = Integer.MIN_VALUE,
			skipRight = Integer.MIN_VALUE;

		if (right - left >= 1) {
			skipLeft = -moreScore(board, left + 2, right, 1 - turn);
			skipRight = -moreScore(board, left, right - 2, 1 - turn);
		}

		int max = Math.max(
			Math.max(takeLeft, takeRight),
			Math.max(skipLeft, skipRight));

		cache.put(cacheKey, max);
		return max;
	}
}
