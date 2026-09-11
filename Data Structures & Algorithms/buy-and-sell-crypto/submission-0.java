class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyValue = prices[0];
        int sellValue = prices[0];
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] < buyValue) {
                buyValue = prices[i];
                sellValue = prices[i];
            } else if (prices[i] > sellValue) sellValue = prices[i];
            maxProfit = Math.max(sellValue - buyValue, maxProfit);
        }
        return maxProfit;
    }
}
