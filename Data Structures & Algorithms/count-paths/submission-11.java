class Solution {
    public int uniquePaths(int m, int n) {
        int totalMoves = (m - 1) + (n - 1);
        int downMoves = m - 1;
        return nCr(totalMoves, downMoves);
    }

    public static int nCr(int n, int r){
        double sum = 1;

        for (int i = 1; i <= r; i ++) {
            sum = sum * (n - r + i) / i;
        }

        return (int) sum;
    }
}
