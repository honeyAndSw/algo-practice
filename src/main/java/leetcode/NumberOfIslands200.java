package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands200 {
	public int numIslands(char[][] grid) {
		int Y = grid.length;
		if (Y == 0) return 0;

		int X = grid[0].length;

		int num = 0;
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (grid[y][x] == '0') continue;

				boolean left = x > 0 && grid[y][x-1] == '1';
				boolean top = y > 0 && grid[y-1][x] == '1';
				boolean right = x < (X - 1) && grid[y][x+1] == '1';
				boolean bottom = y < (Y - 1) && grid[y+1][x] == '1';

				if (!(left || top || right || bottom)) num++;
				else if (x == X - 1 && y == Y - 1) num++;
			}
		}

		return num;
	}

	/* Wrong Answer (35/47) */
	public int numIslands0(char[][] grid) {
		int LEN_Y = grid.length;
		if (LEN_Y == 0) return 0;

		int LEN_X = grid[0].length;

		int[][] PX = new int[LEN_Y][LEN_X];
		int[][] PY = new int[LEN_Y][LEN_X];

		initArray(PX, LEN_X);
		initArray(PY, LEN_Y);

		for (int y = 0; y < LEN_Y; y++) {
			// compare with left / top
			for (int x = 0; x < LEN_X; x++) {
				if (grid[y][x] == '0') continue;

				if ((x == 0 && y == 0) || (x > 0 && grid[y][x-1] == '0') || (y > 0 && grid[y-1][x] == '0')) {
					update(PX, PY, x, y, x, y);
				}

				if (y > 0 && grid[y-1][x] == '1') {
					update(PX, PY, x, y, PX[y-1][x], PY[y-1][x]);
				} else if (x > 0 && grid[y][x-1] == '1') {
					update(PX, PY, x, y, PX[y][x-1], PY[y][x-1]);
				}
			}

			// compare with right
			for (int x = 0; x < LEN_X - 1; x++) {
				if (grid[y][x] == '0') continue;

				if (PY[y][x] > PY[y][x+1]) {
					update(PX, PY, x, y, PX[y][x+1], PY[y][x+1]);
				}
			}
		}

		System.out.println(toString(PX, PY));
		return countUniqueXY(PX, PY, LEN_X);
	}

	private int countUniqueXY(int[][] px, int[][] py, int ignore) {
		Set<String> hash = new HashSet<>();
		int LEN_Y = px.length;
		int LEN_X = px[0].length;

		for (int y = 0; y < LEN_Y; y++) {
			for (int x = 0; x < LEN_X; x++) {
				if (px[y][x] == ignore) continue;
				hash.add(px[y][x] + "," + py[y][x]);
			}
		}

		return hash.size();
	}

	private void initArray(int[][] arr, int val) {
		for (int y = 0; y < arr.length; y++) {
			Arrays.fill(arr[y], val);
		}
	}

	private void update(int[][] px, int[][] py, int x, int y, int xval, int yval) {
		py[y][x] = yval;
		px[y][x] = xval;
	}

	private String toString(int[][] px, int[][] py) {
		int LEN_Y = px.length;
		int LEN_X = px[0].length;

		StringBuilder sb = new StringBuilder();

		for (int y = 0; y < LEN_Y; y++) {
			for (int x = 0; x < LEN_X; x++) {
				sb.append("(").append(px[y][x]).append(",").append(py[y][x]).append(") ");
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}
