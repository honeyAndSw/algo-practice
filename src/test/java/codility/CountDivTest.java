package codility;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 12. 1.
 */
public class CountDivTest {
    CountDiv solution = new CountDiv();

    @Test
    public void test1() throws Exception {
        assertEquals(3, solution.solution(6, 10, 2));
        assertEquals(0, solution.solution(6, 10, 11));
        assertEquals(1, solution.solution(6, 6, 2));
        assertEquals(1, solution.solution(6, 10, 7));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(2000000001, solution.solution(0, 2000000000, 1));
        assertEquals(2, solution.solution(0, 2000000000, 2000000000));
    }

    @Test
    public void test3() throws Exception {
        assertEquals(1, solution.solution(0, 0, 11));
    }

    @Test
    public void test4() throws Exception {
        assertEquals(61499951, solution.solution(100, 123000000, 2));
    }

    @Test
    public void test5() throws Exception {
        //assertEquals(1, solution.solution(10, 10, 5));
        assertEquals(0, solution.solution(10, 10, 7));
        //assertEquals(0, solution.solution(10, 10, 11));
    }
}