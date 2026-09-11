class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) sum += nums[i];
        if (sum % 2 == 1) return false;
        Set<Integer> possible = new HashSet<>();
        possible.add(0);
        for (int i = 0; i < nums.length; i ++) {
            Set<Integer> temp = new HashSet<>();
            for (Integer num : possible) {
                if (num + nums[i] == sum / 2) return true;
                temp.add(num);
                temp.add(num + nums[i]);
            }
            possible = temp;
        }
        return false;
    }
}