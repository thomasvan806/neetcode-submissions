class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text1.length() + 1];

        for (int i = 0; i < text2.length(); i ++) {
            int prev = dp[0];
            for (int j = 1; j < dp.length; j ++) {
                int result = 0;
                int temp = dp[j];
                if (text2.charAt(i) == text1.charAt(j - 1)) {
                    result ++;
                    result += prev;
                } else {
                    result = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
                dp[j] = result;
            }
        }

        return dp[dp.length - 1];
    }
}
