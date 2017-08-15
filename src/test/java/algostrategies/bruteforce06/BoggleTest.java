package algostrategies.bruteforce06;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by honey.and.sw on 2017. 8. 13.
 */
public class BoggleTest {
    @Test
    public void hasWord1() throws Exception {
        char[][] board = new char[5][5];
        String[] boardToStr = {
            "URLPM",
            "XPRET",
            "GIAET",
            "XTNZY",
            "XOQRS"};

        for (int i = 0; i < 5; i++) {
            board[i] = boardToStr[i].toCharArray();
        }

        assertTrue(Boggle.hasWordInBoard(board,"PRETTY"));
        assertTrue(Boggle.hasWordInBoard(board,"GIRL"));
        assertTrue(Boggle.hasWordInBoard(board,"REPEAT"));
        assertFalse(Boggle.hasWordInBoard(board,"KARA"));
        assertFalse(Boggle.hasWordInBoard(board,"PANDORA"));
        assertTrue(Boggle.hasWordInBoard(board,"GIAZAPX"));
    }
}