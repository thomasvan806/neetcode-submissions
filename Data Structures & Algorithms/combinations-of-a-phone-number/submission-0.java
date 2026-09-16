class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.equals("")) return res;
        dfs(digits, 0, "", res);
        return res;
    }
    
    private void dfs(String digits, int i, String curr, List<String> res) {
        if (i >= digits.length()) {
            res.add(curr);
            return;
        }

        int currDigit = Integer.parseInt(digits.charAt(i) + "");
        for (char c : digitToChars(currDigit)) {
            curr += c;
            dfs(digits, i + 1, curr, res);
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    private char[] digitToChars(int digit) {
        if (digit == 2) {
            return new char[]{'a', 'b', 'c'};
        } else if (digit == 3) {
            return new char[]{'d', 'e', 'f'};
        } else if (digit == 4) {
            return new char[]{'g', 'h', 'i'};
        } else if (digit == 5) {
            return new char[]{'j', 'k', 'l'};
        } else if (digit == 6) {
            return new char[]{'m', 'n', 'o'};
        } else if (digit == 7) {
            return new char[]{'p', 'q', 'r', 's'};
        } else if (digit == 8) {
            return new char[]{'t', 'u', 'v'};
        } else {
            return new char[]{'w', 'x', 'y', 'z'};
        }
    }
}
