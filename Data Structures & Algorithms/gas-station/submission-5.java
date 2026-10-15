class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int deficit = gas[0] - cost[0];
        int curr = 0;
        int end = -1;
        int processed = 0;
        while (curr != end) {
            if (processed == cost.length) break;
            if (deficit < 0) {
                int index = end == -1 ? cost.length - 1 : end - 1;
                if (index < 0) index = cost.length - 1;
                deficit += gas[index] - cost[index];
                end = index;
            } else {
                curr ++;
                if (curr == cost.length) curr = 0;
                deficit += gas[curr] - cost[curr];
            }
            processed ++;
        }

        return deficit < 0 ? -1 : curr;
    }
}
