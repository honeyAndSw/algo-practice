package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class NonOverlappingIntervals435 {

    public int eraseOverlapIntervals1(Interval[] intervals) {
        Arrays.sort(intervals,
                (o1, o2) -> (o1.start == o2.start) ? (o1.end - o2.end) : (o1.start - o2.start));

        int ci = 1, pi = 0, erased = 0;
        while (ci < intervals.length) {
            Interval prev = intervals[pi];
            Interval cur = intervals[ci];
            if (prev.start == cur.start || prev.end > cur.start) {
                erased++;
                pi = prev.end > cur.end ? ci : pi;
            } else {
                pi = ci;
            }
            ci++;
        }

        return erased;
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals,
                (o1, o2) -> (o1.start == o2.start) ? (o1.end - o2.end) : (o1.start - o2.start));
        ArrayList<Interval> list = new ArrayList<>();
        list.addAll(Arrays.asList(intervals));

        int i = 1;
        while (i < list.size()) {
            Interval cur = list.get(i);
            Interval prev = list.get(i-1);
            if (prev.start == cur.start || prev.end > cur.start) {
                // (1,5) (2,4) >> (1,5)를 지워야 가장 작은 end를 유지할 수 있음
                // (1,5) (2,3) (4,5)
                list.remove(prev.end > cur.end ? i-1 : i);
            } else {
                i++;
            }
        }

        return intervals.length - list.size();
    }
}
