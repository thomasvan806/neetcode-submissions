class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i ++) {
            int oldMax = max;
            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * oldMax, nums[i] * min));
            res = Math.max(max, res);
        }

        return res;
    }
}
