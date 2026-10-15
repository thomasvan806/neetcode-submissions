class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // -2 curr = 0, end = -1
        // 1 curr = 0, end = 4
        // -1 curr = 1, end = 4
        // 2 curr = 1, end = 3
        // 0 curr = 2, end = 3
        // 0 curr = 3, end = 3

        // -1, curr = 0, end = -1
        // 0, curr = 0, end = 2
        // 
        
        // 2, 0, -1
        // 1, 1, -1
        // 
        int deficit = gas[0] - cost[0];
        int curr = 0;
        int end = -1;
        int processed = 0;
        while (curr != end) {
            // System.out.println(deficit);
            // System.out.println(curr);
            // System.out.println(end);
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
