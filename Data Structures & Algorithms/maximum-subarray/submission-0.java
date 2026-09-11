class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int total = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (total + nums[i] < nums[i]) {
                total = 0;
            }
            total += nums[i];
            if (total > max) max = total;
        }
        return max;
    }
}
