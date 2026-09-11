class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 1;
        for (int i = 0; i < s.length(); i ++) {
            int l = i;
            while ((l - 1 >= 0) && (s.charAt(l - 1) == s.charAt(i))) {
               l --; 
            }
            int r = i;
            while ((r + 1 < s.length()) && (s.charAt(r + 1) == s.charAt(i))) {
                r ++;
            }
            int length = r - l + 1;
            l --;
            r ++;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                length += 2;
                l --;
                r ++;
            }
            if (length > right - left) {
                left = l + 1;
                right = r;
            }
        }
        return s.substring(left, right);
    }
}
