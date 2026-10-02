class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < memo.length; i ++) {
            for (int j = 0; j < memo[i].length; j ++) {
                memo[i][j] = -1;
            }
        }

        return LCS(text1, text2, text1.length() - 1, text2.length() - 1, memo);
    }

    private int LCS(String text1, String text2, int n, int m, int[][] memo) {
        if (n < 0 || m < 0) return 0;
        if (memo[n][m] != -1) return memo[n][m];

        if (text1.charAt(n) == text2.charAt(m)) {
            return memo[n][m] = 1 + LCS(text1, text2, n - 1, m - 1, memo);
        } else {
            return memo[n][m] = Math.max(LCS(text1, text2, n - 1, m, memo), LCS(text1, text2, n, m - 1, memo));
        }
    }
}
