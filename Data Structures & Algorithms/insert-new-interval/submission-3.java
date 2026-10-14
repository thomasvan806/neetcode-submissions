class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];
        boolean added = false;
        for (int i = 0; i < intervals.length; i ++) {
            boolean shouldMerge = (intervals[i][0] < start && start <= intervals[i][1]) || (intervals[i][1] > end && intervals[i][0] <= end) || (start >= intervals[i][0] && end <= intervals[i][1]) || (intervals[i][0] >= start && intervals[i][1] <= end);
            if (shouldMerge) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            } else if (!added && end < intervals[i][0]) {
                result.add(new int[]{start, end});
                added = true;
                i --;
            } else {
                result.add(intervals[i]);
            }
        }

        if (!added) result.add(new int[]{start, end});
        return result.toArray(new int[0][0]);
    }
}
