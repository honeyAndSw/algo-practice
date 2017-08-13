package algostrategies.bruteforce06;

import java.util.Scanner;

/**
 * Created by honey.and.sw on 2017. 8. 13.
 */
public class Boggle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseM = sc.nextInt();
        while (caseM-- > 0) {
            // Make a board
            char[][] board = new char[5][5];
            for (int i = 0; i < 5; i++) {
                String b = sc.next();
                board[i] = b.toCharArray();
            }

            int inputN = sc.nextInt();
            for (int i = 0; i < inputN; i++) {
                String s = sc.next();
                System.out.println(s + " " + (hasWordInBoard(board, s) ? "YES" : "NO"));
            }
        }
    }

    private static int[] diffX = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] diffY = {0, 1, 1, 1, 0, -1, -1, -1};

    public static boolean hasWordInBoard(char[][] board, String s) {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (hasWord(board, x, y, s)) return true;
            }
        }
        return false;
    }

    private static boolean hasWord(char[][] board, int x, int y, String s) {
        // Return condition of recursion
        if (x < 0 || x > 4 || y < 0 || y > 4) return false;
        if (s.length() == 0) return true;

        // If 1st char of s is different from char at (x, y),
        // hasWord cannot continue to search s.
        if (s.charAt(0) != board[y][x]) return false;

        for (int i = 0; i < diffX.length; i++) {
            int newX = x + diffX[i];
            int newY = y + diffY[i];
            if (hasWord(board, newX, newY, s.substring(1))) return true;
        }

        return false;
    }
}
