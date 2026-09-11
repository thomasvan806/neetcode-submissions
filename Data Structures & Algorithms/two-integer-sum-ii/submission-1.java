class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = 0;
        int left = numbers.length - 1;
        while (numbers[right] + numbers[left] != target) {
            if (numbers[right] + numbers[left] > target) left --;
            if (numbers[right] + numbers[left] < target) right ++;
        }
        return new int[]{right + 1, left + 1};
    }
}
