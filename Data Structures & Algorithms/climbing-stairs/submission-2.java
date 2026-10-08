class Solution {
    public int climbStairs(int n) {
        int total = 0;
        int back1 = 1;
        int back2 = 0;
        for (int i = 1; i <= n; i ++) {
            total = 0;
            if (i - 1 >= 0) total += back1;
            if (i - 2 >= 0) total += back2;
            back2 = back1;
            back1 = total;
        }
        return total;
    }
}
