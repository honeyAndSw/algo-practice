package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberOfIslands200Test {
	NumberOfIslands200 solution = new NumberOfIslands200();

	@Test
	public void test0() throws Exception {
		equals(1, new int[][]{
			new int[]{1,1},
			new int[]{1,1}
		});

		equals(2, new int[][]{
			new int[]{1,0},
			new int[]{0,1}
		});

		equals(1, new int[][]{
			new int[]{1,1},
			new int[]{0,1}
		});
	}

	@Test
	public void test1() throws Exception {
		equals(1, new int[][]{
			new int[]{1,1,1},
			new int[]{0,1,0},
			new int[]{1,1,1}
		});

		equals(2, new int[][]{
			new int[]{1,1,1},
			new int[]{0,1,0},
			new int[]{0,0,1}
		});

		equals(3, new int[][]{
			new int[]{1,0,0},
			new int[]{0,1,0},
			new int[]{0,0,1}
		});
	}

	@Test
	public void test2() throws Exception {
		assertEquals(0, solution.numIslands(new char[0][0]));
	}

	@Test
	public void test3() throws Exception {
		equals(1, new int[][]{
			new int[]{1,0,1,1,1},
			new int[]{1,0,1,0,1},
			new int[]{1,1,1,0,1}
		});
	}

	private void equals(int expected, int[][] grid) throws Exception {
		assertEquals(expected, solution.numIslands(toCharArray(grid)));
	}

	private char[][] toCharArray(int[][] grid) {
		char[][] arr = new char[grid.length][grid[0].length];
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[0].length; x++) {
				arr[y][x] = grid[y][x] == 0 ? '0' : '1';
			}
		}
		return arr;
	}
}