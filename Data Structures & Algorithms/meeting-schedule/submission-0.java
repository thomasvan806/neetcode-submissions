/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;

        intervals.sort(new IntervalComparator());

        for (int i = 1; i < intervals.size(); i ++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) return false;
        }

        return true;
    }
}
