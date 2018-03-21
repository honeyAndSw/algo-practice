package leetcode;

public class MaximalSquare221 {

    /* Iterative Backtracking Solution */
    public int maximalSquare1(char[][] matrix) {
        int maxWidth = 0;

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == '1') {
                    int width = 1;
                    while ((y + width - 1) < matrix.length
                        && (x + width - 1) < matrix[0].length
                        && filled(matrix, y, x, width)) {
                        width++;
                    }

                    // `width` would be increased once more than expected.
                    maxWidth = Math.max(maxWidth, width - 1);
                }
            }
        }

        return maxWidth * maxWidth;
    }

    /* Recursive Backtracking Solution */
    public int maximalSquare0(char[][] matrix) {
        int max = 0;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == '1') {
                    max = Math.max(max, maximalSquare(matrix, y, x, 1));
                }
            }
        }
        return max;
    }

    private int maximalSquare(char[][] matrix, int y, int x, int w) {
        int right = x + w - 1, bottom = y + w - 1;
        if (bottom >= matrix.length || right >= matrix[0].length || !filled(matrix, y, x, w)) {
            return 0;
        }
        return Math.max(w * w, maximalSquare(matrix, y, x, w + 1));
    }

    private boolean filled(char[][] matrix, int y, int x, int w) {
        for (int y1 = y; y1 < y + w; y1++) {
            for (int x1 = x; x1 < x + w; x1++) {
                if (matrix[y1][x1] == '0') return false;
            }
        }
        return true;
    }
}
