package algostrategies.bruteforce06;

/**
 * Created by honey.and.sw on 2017. 8. 17.
 */
public class ClockSync {

    static int[][] swtch = {
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

    public static int syncClock(int[] clock, int need, int path) {
        if (need == 0) return path;
        if (path == 9999) return -1;

        int result = -1;

        for (int[] sw : swtch) {
            int needUpdate = updateClock(clock, sw, +1);
            if (needUpdate > need) {
                int after = syncClock(clock, needUpdate, path + 1);

                // result = (result == -1) ? after : Math.min(after, result);
                if (result == -1) {
                    result = after;
                } else if (after != -1) {
                    result = Math.min(after, result);
                }
            }
            updateClock(clock, sw, -1);
        }

        return result;
    }

    public static int updateClock(int[] clock, int[] target, int delta) {
        for (int c : target) {
            int before = clock[c];

            int after;
            if (delta == 1 && before == 0) after = -3; // from 12 to 3
            else if (delta == -1 && before == -3) after = 0; // from 3 to 12
            else after = before + delta;

            clock[c] = after;
        }

        int sum = 0;
        for (int c : clock) sum += c;
        return sum;
    }
}
