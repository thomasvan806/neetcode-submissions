class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = 0;
        int left = numbers.length - 1;
        int sum = numbers[right] + numbers[left];
        while (sum != target) {
            if (sum > target) left --;
            if (sum < target) right ++;
            sum = numbers[right] + numbers[left];
        }
        return new int[]{right + 1, left + 1};
    }
}
