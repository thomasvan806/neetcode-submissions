class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       // optimize space using array
        Map<Integer, Integer> ways = new HashMap<>();
        ways.put(0, 1);
        for (int i = 0; i < nums.length; i ++) {
            Map<Integer, Integer> currWays = new HashMap<>();
            for (Integer t : ways.keySet()) {
                int add = t + nums[i];
                int sub = t - nums[i];
                if (!currWays.containsKey(add)) {
                    currWays.put(add, ways.get(t));
                } else {
                    currWays.put(add, currWays.get(add) + ways.get(t));
                }
                if (!currWays.containsKey(sub)) {
                    currWays.put(sub, ways.get(t));
                } else {
                    currWays.put(sub, currWays.get(sub) + ways.get(t));
                }
            }
            ways = currWays;
        }
        return ways.get(target) == null ? 0 : ways.get(target);
    }
}
