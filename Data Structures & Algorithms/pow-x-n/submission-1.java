class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;

        double result = myPow(x, n/2);
        result *= result;
        if (Math.abs(n % 2) == 1) {
            return n < 0 ? result * (1/x) : result * x;
        } else {
            return result;
        }
    }
}
