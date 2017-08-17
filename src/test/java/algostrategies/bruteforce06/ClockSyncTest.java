package algostrategies.bruteforce06;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 8. 17.
 */
public class ClockSyncTest {
    int[] clock1 = {0, -2, -2, -2, -2, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    @Test
    public void syncClock1() throws Exception {
        /* 12 6 6 6 6 6 12 12 12 12 12 12 12 12 12 12 */
        assertEquals(2, ClockSync.syncClock(clock1, -10, 0));
    }

    @Test
    @Ignore
    public void syncClock2() throws Exception {
        /* 12 9 3 12 6 6 9 3 12 9 12 9 12 12 6 6 */
        int[] clock = {0, -1, -3, 0, -2, -2, -1, -3, 0, -1, 0, -1, 0, 0, -2, -2};

        int need = 0;
        for (int c : clock) need += c;

        assertEquals(9, ClockSync.syncClock(clock, need, 0));
    }

    @Test
    public void updateClock1() throws Exception {
        int[] expected = {0, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int result = ClockSync.updateClock(clock1, new int[]{1, 2, 3, 4, 5}, 1);

        assertTrue(Arrays.equals(expected, clock1));
        assertEquals(-5, result);

        int result2 = ClockSync.updateClock(clock1, new int[]{1, 2, 3, 4, 5}, -1);
        assertTrue(Arrays.equals(new int[]{0, -2, -2, -2, -2, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, clock1));
        assertEquals(-10, result2);
    }
}