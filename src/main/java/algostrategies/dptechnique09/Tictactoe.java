package algostrategies.dptechnique09;

import java.util.Scanner;

/**
 * Tictactoe
 */
public class Tictactoe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for (int c = 0; c < cases; c++) {
			String[] state = new String[3];
			state[0] = sc.next();
			state[1] = sc.next();
			state[2] = sc.next();
			System.out.println(canWin(state));
		}
	}

	public static String canWin(String[] state) {
		int xCnt = count(state, "x");
		int oCnt = count(state, "o");

		String now = xCnt == oCnt ? "x" : "o";
		String before = now.equals("x") ? "o" : "x";

		if (win(state, before)) return before;
		else if (win(state, now)) return now;
		else if (xCnt + oCnt == 9) return "TIE";

		boolean canTie = false;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!".".equals(state[i].charAt(j) + "")) {
					continue;
				}

				// Set & reset should be done right before, and right after `nextTurn`.
				state[i] = state[i].substring(0, j) + now + state[i].substring(j + 1, 3);
				String nextTurn = canWin(state);
				state[i] = state[i].substring(0, j) + "." + state[i].substring(j + 1, 3);

				if (nextTurn.equals(now)) {
					return nextTurn;
				} else if (nextTurn.equals("TIE")) {
					canTie = true;
				}
			}
		}

		// Possible 3 cases have priority:
		// 1) `now` wins => returns immediately inside for-loop
		// 2) TIE => sets a flag and continue to check higher priority case could happen
		// 3) `before` wins => if 1), 2) fails, then use this
		return canTie ? "TIE" : before;
	}

	private static int count(String[] state, String sym) {
		int count = 0;
		for (String s : state) {
			for (char c : s.toCharArray()) {
				if (sym.equals(c + "")) {
					count++;
				}
			}
		}
		return count;
	}

	private static boolean win(String[] state, String sym) {
		char c = sym.toCharArray()[0];

		for (int i = 0; i < 3; i++) {
			if (state[i].equals(sym + sym + sym)) return true;
			if (state[0].charAt(i) == c && state[1].charAt(i) == c && state[2].charAt(i) == c) return true;
		}

		return (state[0].charAt(0) == c && state[1].charAt(1) == c && state[2].charAt(2) == c)
			|| (state[0].charAt(2) == c && state[1].charAt(1) == c && state[2].charAt(0) == c);
	}
}
