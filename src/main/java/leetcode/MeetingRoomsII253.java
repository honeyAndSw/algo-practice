package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MeetingRoomsII253 {
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	public int minMeetingRooms(Interval[] intervals) {
		// Use lambda instead of Comparator.
		// new Comparator<Interval>() {
		// 	public int compare(Interval i1, Interval i2) {
		// 		return i1.start - i2.start;
		// 	}
		// }
		Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
		List<Interval> rooms = new LinkedList<>();

		for (Interval itv : intervals) {
			Interval mergeTo = null;
			for (Interval room : rooms) {
				if (room.end <= itv.start || itv.end <= room.start) { // room -> itv, itv -> room
					mergeTo = room;
					break;
				}
			}

			if (mergeTo == null) {
				rooms.add(itv);
			} else {
				Interval mergedInterval = (mergeTo.end <= itv.start)
					? new Interval(mergeTo.start, itv.end)
					: new Interval(itv.start, mergeTo.end);
				rooms.remove(mergeTo);
				rooms.add(mergedInterval);
			}
		}

		return rooms.size();
	}
}
