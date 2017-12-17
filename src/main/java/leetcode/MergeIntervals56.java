package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by honey.and.sw on 2017. 12. 17.
 */
public class MergeIntervals56 {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        for (Interval interval : intervals) { // O(N), N = # of intervals
            List<Interval> overwraps = removeOverwraps(result, interval); // O(N)

            int start = Integer.MAX_VALUE;
            int end = Integer.MIN_VALUE;
            for (Interval ow : overwraps) {
                start = Math.min(start, ow.start);
                end = Math.max(end, ow.end);
            }

            result.add(new Interval(start, end));
        }

        return result;
    }

    private List<Interval> removeOverwraps(List<Interval> list, Interval itv1) {
        List<Interval> overwraps = new ArrayList<>();

        for (int i = 0; i < list.size();) {
            Interval itv2 = list.get(i);
            boolean condition1 = (itv1.start <= itv2.start) ? (itv2.start <= itv1.end) : (itv1.start <= itv2.end);
            boolean condition2 = (itv1.start <= itv2.start) ? (itv1.end >= itv2.end) : (itv1.end <= itv2.end);

            if (condition1 || condition2) {
                overwraps.add(list.remove(i));
            } else {
                i++;
            }
        }

        overwraps.add(itv1);
        return overwraps;
    }

}
