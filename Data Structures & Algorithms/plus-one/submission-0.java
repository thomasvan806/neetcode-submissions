class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length];
        boolean carry = true;

        for (int i = digits.length - 1; i >= 0; i --) {
            if (carry) {
                int add = digits[i] + 1;
                if (add == 10) {
                    res[i] = 0;
                    carry = true;
                } else {
                    res[i] = add;
                    carry = false;
                }
            } else {
                res[i] = digits[i];
            }
        }

        if (res[0] == 0) {
            int[] next = new int[res.length + 1];
            next[0] = 1;
            for (int i = 0; i < res.length; i ++) {
                next[i + 1] = res[i];
            }
            return next;
        }
        return res;
    }
}
