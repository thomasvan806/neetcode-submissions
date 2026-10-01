class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[dp.length - 1] = 1;
        int res = 1;
        for (int i = dp.length - 2; i >= 0; i --) {
            int max = 0;
            for (int j = i; j < dp.length; j ++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
