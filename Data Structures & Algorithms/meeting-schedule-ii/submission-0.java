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
    public int minMeetingRooms(List<Interval> intervals) {
        Comparator<Interval> c = (a, b) -> a.start - b.start;
        intervals.sort(c);

        List<Integer> ends = new ArrayList<>();
        for (Interval i : intervals) {
            if (ends.isEmpty()) {
                ends.add(i.end);
            } else {
                boolean added = false;
                for (int index = 0; index < ends.size(); index ++) {
                    if (i.start >= ends.get(index)) {
                        ends.set(index, i.end);
                        added = true;
                        break;
                    }
                }
                if (!added) ends.add(i.end);
            }
        }

        return ends.size();
    }
}
