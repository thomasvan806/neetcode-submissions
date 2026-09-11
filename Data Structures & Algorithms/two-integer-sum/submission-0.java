class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int curr = nums[i];
            if (indices.containsKey(target - curr)) {
                return new int[]{indices.get(target - curr), i};
            }
            indices.put(curr, i);
        }
        return new int[0];
    }
}
