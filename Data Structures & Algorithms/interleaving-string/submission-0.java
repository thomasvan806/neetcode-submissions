class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // check if curr in s3 is equal to curr in s1 or s2
        // continue if is in either
        return helper(s1, s2, s3, 0, 0);
    }

    private boolean helper(String s1, String s2, String s3, int i, int j) {
        if (i + j > s3.length() - 1) return true;
        if (s1.charAt(i) == s3.charAt(i + j) && s2.charAt(i) == s3.charAt(i + j)) {
            return helper(s1, s2, s3, i + 1, j) || helper(s1, s2, s3, i, j + 1);
        } else if (s1.charAt(i) == s3.charAt(i + j)) {
            return helper(s1, s2, s3, i + 1, j);
        } else if (s2.charAt(i) == s3.charAt(i + j)) {
            return helper(s1, s2, s3, i, j + 1);
        } else {
            return false;
        }
    }
}
