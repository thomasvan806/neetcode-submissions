class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> memo = new HashMap<>();
        memo.put(s.length(), true);
        return dfs(s, wordDict, 0, memo);
    }

    private boolean dfs(String s, List<String> wordDict, int i, Map<Integer, Boolean> memo) {
        if (memo.containsKey(i)) return memo.get(i);

        for (String word : wordDict) {
            if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                if (dfs(s, wordDict, i + word.length(), memo)) {
                    memo.put(i, true);
                    return true;
                }
            }
        }
        memo.put(i, false);
        return false;
    }
}
