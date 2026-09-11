class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            while (!isAscii(leftChar)) {
                left ++;
                if (left >= right) return true;
                leftChar = s.charAt(left);
            }
            while (!isAscii(rightChar)) {
                right --;
                if (left >= right) return true;
                rightChar = s.charAt(right);
            }
            if (!(leftChar + "").toLowerCase().equals((rightChar + "").toLowerCase())) return false;
            left ++;
            right --;
        }
        return true;
    }

    private boolean isAscii(char c) {
        int ascii = (int) c;
        return (c >= 48 && c <= 57) ||
                (c >= 65 && c <= 90) ||
                (c >= 97 && c <= 122);
    }
}
