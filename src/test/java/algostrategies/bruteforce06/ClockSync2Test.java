package algostrategies.bruteforce06;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 8. 17.
 */
public class ClockSync2Test {
    @Test
    public void syncClock1() throws Exception {
        int[] clock = {12, 6, 6, 6, 6, 6, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
        assertEquals(2, ClockSync2.syncClock(clock, 0));
    }

    @Test
    public void syncClock2() throws Exception {
        int[] clock = {12, 9, 3, 12, 6, 6, 9, 3, 12, 9, 12, 9, 12, 12, 6, 6};
        assertEquals(9, ClockSync2.syncClock(clock, 0));
    }
}