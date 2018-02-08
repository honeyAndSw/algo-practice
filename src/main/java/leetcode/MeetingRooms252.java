package leetcode;

import java.util.Arrays;

public class MeetingRooms252 {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1].end > intervals[i].start) return false;
        }
        return true;
    }
}
