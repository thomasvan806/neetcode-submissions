class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // check if curr in s3 is equal to curr in s1 or s2
        // continue if is in either
        return helper(s1, s2, s3, 0, 0);
    }

    private boolean helper(String s1, String s2, String s3, int i, int j) {
        boolean ins1 = i <= s1.length() - 1;
        boolean ins2 = j <= s2.length() - 1;
        if (i + j >= s3.length()) return true;
        if (ins1 && ins2 && s1.charAt(i) == s3.charAt(i + j) && s2.charAt(j) == s3.charAt(i + j)) {
            return helper(s1, s2, s3, i + 1, j) || helper(s1, s2, s3, i, j + 1);
        } else if (ins1 && s1.charAt(i) == s3.charAt(i + j)) {
            return helper(s1, s2, s3, i + 1, j);
        } else if (ins2 && s2.charAt(j) == s3.charAt(i + j)) {
            return helper(s1, s2, s3, i, j + 1);
        } else {
            return false;
        }
    }
}
