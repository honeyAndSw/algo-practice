package algostrategies.bruteforce06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by honey.and.sw on 2017. 8. 17.
 */
public class ClockSync2 {

    static int[][] swtchToClocks = {
        {0, 1, 2},
        {3, 7, 9, 11},
        {4, 10, 14, 15},
        {0, 4, 5, 6, 7},
        {6, 7, 8, 10, 12},
        {0, 2, 14, 15},
        {3, 14, 15},
        {4, 5, 7, 14, 15},
        {1, 2, 3, 4, 5},
        {3, 4, 5, 9, 13}
    };

    private static int INF = 987654321;
    private static int CLOCK_SIZE = 16;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseN = sc.nextInt();
        while (caseN-- > 0) {
            int[] clock = new int[CLOCK_SIZE];
            for (int i = 0; i < CLOCK_SIZE; i++) {
                clock[i] = sc.nextInt();
            }
            int count = syncClock(clock, 0);
            System.out.println(count >= INF ? -1 : count);
        }
    }

    public static int syncClock(int[] clock, int swtch) {
        // Every switch is pushed at most 4 times each.
        if (swtch == swtchToClocks.length) {
            for (int c : clock) {
                if (c != 12) return INF;
            }
            return 0;
        }

        int result = INF;

        /* clock doesn't need to be backed-up.
            In the format of (swtch, count):
            (i, 0) ==>  (i+1, 0)
                        (i+1, 1)
                        (i+1, 2)
                        (i+1, 3)
            (i, 0) <==  returns
            clock remains the same here, because (i+1) switch is pushed 4 times
            which then backs to the original clock before.

            (i, 1) ==> ...
            (i, 2) ==> ...
            (i, 3) ==> ...
        */
        for (int i = 0; i < 4; i++) {
            // after = (the number of times `swtch` is pushed) + (min count of next)
            int after = i + syncClock(clock, swtch + 1);
            result = Math.min(result, after);
            // updateClock should be called after the first syncClock
            // for the case when `swtch` is not pushed.
            clock = updateClock(clock, swtchToClocks[swtch]);
        }

        return result;
    }

    private static int[] updateClock(int[] clock, int[] target) {
        for (int t : target) {
            clock[t] += 3;
            if (clock[t] == 15) clock[t] = 3;
        }
        return clock;
    }
}
