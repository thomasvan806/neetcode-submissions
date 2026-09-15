class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> curr, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        dfs(nums, i + 1, curr, res);
        curr.remove(curr.size() - 1);
        int original = nums[i];
        while (i < nums.length && nums[i] == original) {
            i ++;
        }
        dfs(nums, i, curr, res);
    }
}
