class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int min = 1;
        int max = nums.length;
        int mid = (min + max) / 2;

        while (min <= max) {
            if (nums[mid - 1] > nums[mid % nums.length]) {
                return nums[mid % nums.length];
            }

            int checkIndex = (mid - 1) - (mid + 1);
            if (checkIndex < 0) checkIndex += nums.length;
            if (nums[checkIndex] < nums[mid - 1]) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
            mid = (min + max) / 2;
            // 4, 5, 6, 1, 2, 3

        }

        return nums[0];
    }
}
