class Solution {
    public int search(int[] nums, int target) {
        // if curr index > next index, that is the point of rotation
        // min rotation 1
        // max rotation n
        // if 
        int rotations = 0;

        int min = 1;
        int max = nums.length;
        int mid = (min + max) / 2;

        while (min <= max) {
            if (nums[mid - 1] > nums[mid % nums.length]) {
                rotations = mid;
                break;
            }

            int checkIndex = (mid - 1) - (mid + 1);
            if (checkIndex < 0) checkIndex += nums.length;
            if (nums[mid - 1] < checkIndex) {
                if (nums[checkIndex] > nums[(checkIndex + 1) % nums.length]) {
                    rotations = checkIndex + 1;
                    break;
                }
                max = mid - 1;
            } else {
                min = mid + 1;
            }
            mid = (min + max) / 2;
        }

        min = 0;
        max = nums.length - 1;
        mid = (min + max) / 2;

        while (min < max && nums[mid] != target) {
            int index = (mid + rotations) % nums.length;

            if (nums[index] == target) return index;

            if (nums[index] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }

            mid = (min + max) / 2;
        }

        int index = (mid + rotations) % nums.length;
        return nums[index] == target ? index : -1;
    }
}
