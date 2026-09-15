class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int target, int i, int sum, List<Integer> curr, List<List<Integer>> res) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        if (i >= nums.length) return;

        curr.add(nums[i]);
        dfs(nums, target, i, sum + nums[i], curr, res);
        curr.remove(curr.size() - 1);
        dfs(nums, target, i + 1, sum, curr, res);
    }
}
