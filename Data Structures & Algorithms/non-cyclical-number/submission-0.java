class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n)) return false;
            seen.add(n);
            n = calc(n);
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
