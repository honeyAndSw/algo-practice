package leetcode;

import java.util.Arrays;

public class SparseMatricMultiplication311 {
    public int[][] multiply(int[][] A, int[][] B) {
        int ROW = A.length;
        int COLUMN = B[0].length;

        int[][] multiply = new int[ROW][COLUMN];
        for (int i = 0; i < ROW; i++) {
            Arrays.fill(multiply[i], -1); // not yet calculated.
        }

        for (int i = 0; i < A.length; i++) {
            boolean allZero = true;
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                Arrays.fill(multiply[i], 0);
            }
        }
        for (int i = 0; i < B[0].length; i++) {
            boolean allZero = true;
            for (int j = 0; j < B.length; j++) {
                if (B[j][i] != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                for (int r = 0; r < ROW; r++) {
                    multiply[r][i] = 0;
                }
            }
        }

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COLUMN; c++) {
                if (multiply[r][c] != 0) {
                    multiply[r][c] = multiply(A, r, B, c);
                }
            }
        }

        return multiply;
    }

    private int multiply(int[][] A, int r, int[][] B, int c) {
        int sum = 0;
        for (int i = 0; i < A[0].length; i++) {
            sum += A[r][i] * B[i][c];
        }
        return sum;
    }
}
