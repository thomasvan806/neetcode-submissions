class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] counts = new int[amount + 1];
        for (int i = 1; i < counts.length; i ++) {
            for (int j = 0; j < coins.length; j ++) {
                if (i - coins[j] == 0) {
                    counts[i] = 1;
                } else if (i - coins[j] > 0 && counts[i - coins[j]] > 0) {
                    counts[i] = counts[i] == 0 ? counts[i - coins[j]] + 1 : Math.min(counts[i], counts[i - coins[j]] + 1);
                }
            }
        }
        return counts[counts.length - 1] == 0 ? -1 : counts[counts.length - 1];
    }
}
