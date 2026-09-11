class Solution {
    public int rob(int[] nums) {
        int max = 0;
        int maxSoFar = 0;
        int skip = 0;
        int doubleSkip = 0;
        for (int i = 0; i < nums.length; i ++) {
            int temp = maxSoFar;
            int temp2 = skip;
            maxSoFar = Math.max(skip + nums[i], doubleSkip + nums[i]);
            if (maxSoFar > max) max = maxSoFar;
            if (i > 0) {
                skip = temp;
            }
            if (i > 1) {
                doubleSkip = temp2;
            }
        }
        return max;
    }
}
