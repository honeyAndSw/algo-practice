package algostrategies.dp08;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 9. 3.
 */
public class PiTest {
    @Test
    public void testGrade_minimumDigits() throws Exception {
        assertEquals(1, Pi.grade(new int[]{3, 3, 3}));
        assertEquals(2, Pi.grade(new int[]{3, 2, 1}));
        assertEquals(2, Pi.grade(new int[]{1, 2, 3}));
        assertEquals(4, Pi.grade(new int[]{3, 2, 3}));
        assertEquals(5, Pi.grade(new int[]{1, 4, 7}));
        assertEquals(5, Pi.grade(new int[]{7, 4, 1}));
        assertEquals(10, Pi.grade(new int[]{1, 5, 7}));
    }

    @Test
    public void testGrade_example() throws Exception {
        assertEquals(4, Pi.grade(new int[]{1,2,3,4,1,2,3,4}));
        assertEquals(2, Pi.grade(new int[]{1,1,1,1,1,2,2,2}));
        assertEquals(2, Pi.grade(new int[]{2,2,2,2,2,2,2,2}));
        assertEquals(5, Pi.grade(new int[]{1,2,1,2,2,2,2,2}));
        assertEquals(14, Pi.grade(new int[]{1,2,6,7,3,9,3,9}));
    }

    @Test
    public void testGrade() throws Exception {
        assertEquals(2, Pi.grade(new int[]{1,2,3,4,5}));
        assertEquals(4, Pi.grade(new int[]{1,2,3,1,2,3,4,5}));
        assertEquals(4, Pi.grade(new int[]{1,2,3,4,5,1,2,3,4,5}));
    }

    @Test
    public void testGrade_example2() throws Exception {
        assertEquals(20, Pi.grade(new int[]{5,3,0,5,0,6,8,2,0,3}));
    }

    @Test
    public void testGrade_example3() throws Exception {
        assertEquals(60, Pi.grade(new int[]{2,0,8,9,9,8,6,2,8,0,3,4,8,2,5,3,4,2,1,1,7,0,6,7,9,8,2}));
    }
}