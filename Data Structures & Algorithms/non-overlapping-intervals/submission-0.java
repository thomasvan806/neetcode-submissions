class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        Comparator<int[]> c = (a, b) -> {
            if (a[1] - b[1] != 0) return a[1] - b[1];

            return b[0] - a[0];
        };

        Arrays.sort(intervals, c);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i ++) {
            int[] currInterval = intervals[i];

            if (currInterval[0] < end) {
                result ++;
            } else {
                start = currInterval[0];
                end = currInterval[1];
            }
        }

        return result;
    }
}
