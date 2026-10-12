class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Comparator<int[]> c = (a, b) -> a[0] - b[0];
        Arrays.sort(intervals, c);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i ++) {
            int[] currInterval = intervals[i];
            if (currInterval[0] <= end) {
                end = Math.max(end, currInterval[1]);
            } else {
                result.add(new int[]{start, end});
                start = currInterval[0];
                end = currInterval[1];
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(new int[0][0]);
    }
}
