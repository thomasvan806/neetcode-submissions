class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int i, int sum, List<Integer> curr,
        List<List<Integer>> res) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i >= candidates.length) return;

        curr.add(candidates[i]);
        dfs(candidates, target, i + 1, sum + candidates[i], curr, res);
        curr.remove(curr.size() - 1);
        int original = candidates[i];
        while (i < candidates.length && candidates[i] == original) {
            i ++;
        }
        dfs(candidates, target, i, sum, curr, res);
    }
}
