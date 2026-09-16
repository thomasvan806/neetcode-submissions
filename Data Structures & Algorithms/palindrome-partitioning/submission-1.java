class Solution {
    public List<List<String>> partition(String s) {
        // aab
        // a ab
        // aa b
        // a a b
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res, "", 0);
        return res;
    }

    private void dfs(String s, int i, List<String> curr, List<List<String>> res, String c, int total) {
        if (i >= s.length()) {
            if (total == s.length()) {
                for (String s1 : curr) {
                    if (!isPalindrome(s1)) return;
                }
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        c += s.charAt(i);
        curr.add(c);
        dfs(s, i + 1, curr, res, "", total + c.length());
        curr.remove(curr.size() - 1);
        dfs(s, i + 1, curr, res, c, total);
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left ++;
            right --;
        }

        return true;
    }
}
