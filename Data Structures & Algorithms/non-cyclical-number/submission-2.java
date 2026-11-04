class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = calc(n);
        while (fast != 1) {
            if (slow == fast) return false;
            slow = calc(slow);
            fast = calc(calc(fast));
        }
        return true;
    }

    private int calc(int i) {
        int result = 0;
        while (i > 0) {
            int currDigit = i % 10;
            result += currDigit * currDigit;
            i /= 10;
        }
        return result;
    }
}
