package leetcode;

/**
 * Created by honey.and.sw on 2018. 2. 3.
 */
public class MaximalRectangle85 {

    /* Time Limit Exceeded */
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == '1') {
                    int[] start = new int[]{y, x};
                    max = Math.max(max, maximalRectangle(matrix, start, start));
                }
            }
        }
        return max;
    }

    private int maximalRectangle(char[][] matrix, int[] xy0, int[] xy1) {
        int max = (xy1[0] - xy0[0] + 1) * (xy1[1] - xy0[1] + 1);

        if ((xy1[1] < matrix[0].length - 1)
                && filled(matrix, new int[]{xy0[0], xy1[1] + 1}, new int[]{xy1[0], xy1[1] + 1})) {
            max = Math.max(max,
                    maximalRectangle(matrix, xy0, new int[]{xy1[0], xy1[1] + 1}));
        }

        if ((xy1[0] < matrix.length - 1)
                && filled(matrix, new int[]{xy1[0] + 1, xy0[1]}, new int[]{xy1[0] + 1, xy1[1]})) {
            max = Math.max(max,
                    maximalRectangle(matrix, xy0, new int[]{xy1[0] + 1, xy1[1]}));
        }

        return max;
    }

    private boolean filled(char[][] matrix, int[] xy0, int[] xy1) {
        for (int y = xy0[0]; y <= xy1[0]; y++) {
            for (int x = xy0[1]; x <= xy1[1]; x++) {
                if (matrix[y][x] == '0') return false;
            }
        }
        return true;
    }
}
