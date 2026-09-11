class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int jumps = 1;
        int currJump = nums[0];
        int nextJump = 1 + nums[1];
        for (int i = 1; i < nums.length; i ++) {
            if (currJump >= nums.length - 1) return jumps;
            if (i > currJump) {
                jumps ++;
                currJump = nextJump;
            }
            nextJump = Math.max(nextJump, i + nums[i]);
        }
        return jumps;
    }
}
