package leetcode.utils;

/**
 * Created by honey.and.sw on 2018. 2. 3.
 */
public class Arrays {
    public static char[][] toCharArray(int[][] grid) {
        char[][] arr = new char[grid.length][grid[0].length];
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                arr[y][x] = grid[y][x] == 0 ? '0' : '1';
            }
        }
        return arr;
    }
}
