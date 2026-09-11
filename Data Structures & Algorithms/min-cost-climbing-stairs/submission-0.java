class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // min cost to get to step 4
        // min of min cost to get to step 3 + cost of step 3
        // and min cost to get to step 2 + cost of step 2
        // base case cost to get to step 0 and 1 is 0,
        // Since we can start at steps 0 or 1, the costs of getting to those steps is 0.
        int oneBeforeCost = 0;
        int twoBeforeCost = 0;
        // cost.length + 1 to simulate top of floor
        for (int i = 2; i < cost.length + 1; i ++) {
            int temp = oneBeforeCost;
            oneBeforeCost = Math.min(oneBeforeCost + cost[i - 1], twoBeforeCost + cost[i - 2]);
            twoBeforeCost = temp;
        }
        return oneBeforeCost;
    } 
}
