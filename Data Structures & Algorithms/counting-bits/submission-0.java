class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int nextPowerOfTwo = 1;
        for (int i = 1; i <= n; i ++) {
            if (i == nextPowerOfTwo) {
                ans[i] = 1;
                nextPowerOfTwo *= 2;
            } else if (i % 2 == 1) {
                ans[i] = ans[i - 1] + ans[1];
            } else {
                ans[i] = ans[nextPowerOfTwo / 2] + ans[i - nextPowerOfTwo / 2];
            }
        }
        return ans;
    }
}
