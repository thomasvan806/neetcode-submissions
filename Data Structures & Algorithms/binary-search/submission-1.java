class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = (right + left) / 2;
        while (nums[index] != target && left < right) {
            if (nums[index] < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
            index = (right + left) / 2;
        }
        return nums[index] == target ? index : -1;
    }
}
