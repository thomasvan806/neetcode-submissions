class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // -4, -1, -1, 0, 1, 2
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int target = -1 * nums[i];
            while (j < k) {
                if (nums[j] + nums[k] < target) {
                    j++;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    int prevJ = nums[j];
                    int prevK = nums[k];
                    j ++;
                    k --;
                    while (j < k && nums[j] == prevJ) {
                        j ++;
                    }
                    while (j < k && nums[k] == prevK) {
                        k --;
                    }
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i ++;
            }
        }

        return result;
    }
}
