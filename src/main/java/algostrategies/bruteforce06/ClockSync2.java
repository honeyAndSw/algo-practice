package algostrategies.bruteforce06;

import java.util.Arrays;

/**
 * Created by honey.and.sw on 2017. 8. 17.
 */
public class ClockSync2 {
    static int[][] swtchToClocks = {
        {0, 1, 2}, /* [0] */
        {3, 7, 9, 11},
        {4, 10, 14, 15}, /* [2] */
        {0, 4, 5, 6, 7},
        {6, 7, 8, 10, 12}, /* [4] */
        {0, 2, 14, 15},
        {3, 14, 15}, /* [6] */
        {4, 5, 7, 14, 15},
        {1, 2, 3, 4, 5}, /* [8] */
        {3, 4, 5, 9, 13}
    };

    private static int INF = 987654321;

    public static int syncClock(int[] clock, int swtch) {
        // Every switch is pushed 4 times each.
        if (swtch == swtchToClocks.length) {
            for (int c : clock) {
                if (c != 12) return INF;
            }
            return 0;
        }

        int result = INF;
        for (int i = 0; i < 4; i++) {
            int[] backupClock = Arrays.copyOf(clock, clock.length);
            int after = 1 + syncClock(clock, swtch + 1);
            result = Math.min(result, after);
            // updateClock should be called after the first syncClock
            // for the case when `swtch` is not pushed.
            clock = updateClock(backupClock, swtchToClocks[swtch]);
        }

        return result;
    }

    public static int[] updateClock(int[] clock, int[] target) {
        for (int t : target) {
            clock[t] += 3;
            if (clock[t] == 15) clock[t] = 3;
        }
        return clock;
    }

}
