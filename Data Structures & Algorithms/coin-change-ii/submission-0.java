class Solution {
    public int change(int amount, int[] coins) {
        int[] arr = new int[amount + 1];
        arr[0] = 1;

        for (int i = 1; i < coins.length + 1; i ++) {
            for (int j = 1; j < amount + 1; j ++) {
                arr[j] = arr[j] + (j >= coins[i - 1] ? arr[j - coins[i - 1]] : 0);
            }
        }

        return arr[amount];
    }
}