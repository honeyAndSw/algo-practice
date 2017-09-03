package algostrategies.dp08;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 9. 3.
 */
public class PiTest {
    @Test
    public void testGrade_minimumDigits() throws Exception {
        assertEquals(1, Pi.level(new int[]{3, 3, 3}));
        assertEquals(2, Pi.level(new int[]{3, 2, 1}));
        assertEquals(2, Pi.level(new int[]{1, 2, 3}));
        assertEquals(4, Pi.level(new int[]{3, 2, 3}));
        assertEquals(5, Pi.level(new int[]{1, 4, 7}));
        assertEquals(5, Pi.level(new int[]{7, 4, 1}));
        assertEquals(10, Pi.level(new int[]{1, 5, 7}));
    }

    @Test
    public void testGrade_example() throws Exception {
        assertEquals(4, Pi.level(new int[]{1,2,3,4,1,2,3,4}));
        assertEquals(2, Pi.level(new int[]{1,1,1,1,1,2,2,2}));
        assertEquals(2, Pi.level(new int[]{2,2,2,2,2,2,2,2}));
        assertEquals(5, Pi.level(new int[]{1,2,1,2,2,2,2,2}));
        assertEquals(14, Pi.level(new int[]{1,2,6,7,3,9,3,9}));
    }

    @Test
    public void testGrade() throws Exception {
        assertEquals(2, Pi.level(new int[]{1,2,3,4,5}));
        assertEquals(4, Pi.level(new int[]{1,2,3,1,2,3,4,5}));
        assertEquals(4, Pi.level(new int[]{1,2,3,4,5,1,2,3,4,5}));
    }

    @Test
    public void testGrade_example2() throws Exception {
        assertEquals(20, Pi.level(new int[]{5,3,0,5,0,6,8,2,0,3}));
        assertEquals(60, Pi.level(new int[]{2,0,8,9,9,8,6,2,8,0,3,4,8,2,5,3,4,2,1,1,7,0,6,7,9,8,2}));
    }

    @Test
    public void testGrade_example3() throws Exception {
        // [10] 98, -1, -1, 94,
        // [ 4] 88, 94, 90,
        // [10] 84, 84, 84, 84, 80,
        // [10] 74, 74, 74, 74, 70,
        // [ 4] 64, 64, 64, 64,
        // 60, 60, 60, 54, 54, 50, 50, 50, 44, 44, 40, 40, 40, 34, 34, 30, 30,
        // 30, 24, 24, 20, 20, 20, 14, 20, 10, 10, 10, 10, 10,
        assertEquals(100, Pi.level(new int[]{
            2,1,8,4, // 10
            2,7,2, // 4
            5,5,0,2,5, // 10
            4,2,5,6,8, // 10
            8,7,6, // 4
            7,1,7,9,0,
            4,9,4,
            6,0,1,
            6,5,3,4,
            6,6,8,0,4,
            9,8,8,6,2,
            7,2,3,2,7,9}));
    }
}