package leetcode;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[0].length; x++) {
				if (board[y][x] == word.charAt(0)) {
					char bak = clear(board, y, x);
					if (exist(board, y, x, word, 1)) {
						return true;
					} else {
						set(board, y, x, bak);
					}
				}
			}
		}
		return false;
	}

	private int[] diffY = new int[]{-1, 0, 1, 0};
	private int[] diffX = new int[]{0, 1, 0, -1};

	// (y,x) current position in board
	// x next character to find from current position
	private boolean exist(char[][] board, int y, int x, String word, int s) {
		if (s == word.length()) return true;

		for (int d = 0; d < 4; d++) {
			int y1 = y + diffY[d];
			int x1 = x + diffX[d];
			if (y1 >= 0 && y1 < board.length && x1 >= 0 && x1 < board[0].length && board[y1][x1] == word.charAt(s)) {
				char bak = clear(board, y1, x1);
				if (exist(board, y1, x1, word, s + 1)) {
					return true;
				} else {
					set(board, y1, x1, bak);
				}
			}
		}

		return false;
	}

	private char clear(char[][] board, int y, int x) {
		char bak = board[y][x];
		board[y][x] = ' ';
		return bak;
	}

	private void set(char[][] board, int y, int x, char ch) {
		board[y][x] = ch;
	}
}
