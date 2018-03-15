package leetcode;

public class MaximalSquare221 {
    private boolean[][] foundSquare;

    /* runtime 3.92% */
    public int maximalSquare(char[][] matrix) {
        int maxwidth = 0;
        // foundSquare = new boolean[matrix.length];
        // for (int i = 0; i < matrix.length; i++) {
        //    foundSquare[i] = new boolean[matrix[0].length];
        // }

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == '1') {
                    maxwidth = Math.max(maxwidth, maximalSquare(matrix, y, x, 1));

                    // Update foundSquare
                    // for (int w = 1; w < maxwidth; w++) {
                    //    foundSquare[y + w][x + w] = true;
                    // }
                }
            }
        }
        return maxwidth * maxwidth;
    }

    private int maximalSquare(char[][] matrix, int y, int x, int w) {
        // Check foundSquare

        int right = x + w - 1, bottom = y + w - 1;
        if (bottom >= matrix.length || right >= matrix[0].length || !filled(matrix, y, x, w)) {
            return 0;
        }
        return Math.max(w, maximalSquare(matrix, y, x, w + 1));
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
