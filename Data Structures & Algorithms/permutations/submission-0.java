class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // need for loop inside of recursive case to choose which number to do next
        // base case is when the array of bools is all true
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, boolean[] chosen, int pos, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (pos >= nums.length) return;

        for (int i = 0; i < chosen.length; i ++) {
            if (!chosen[i]) {
                chosen[i] = true;
                curr.add(nums[i]);
                dfs(nums, chosen, pos + 1, curr, res);
                chosen[i] = false;
                curr.remove(curr.size() - 1);
                dfs(nums, chosen, pos + 1, curr, res);
            }
        }
    }
}
