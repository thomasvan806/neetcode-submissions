class Solution {
    public boolean isValid(String s) {
        Stack<Character> open = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char curr = s.charAt(i);
            if (open.isEmpty()) return false;
            if (isClosing(curr)) {
                if (!matches(open.pop(), curr)) return false;
            } else {
                open.push(curr);
            }
        }
        return true;
    }

    private boolean matches(char a, char b) {
        return a == '(' && b == ')' ||
            a == '[' && b == ']' ||
            a == '{' && b == '}';
    }

    private boolean isClosing(char c) {
        return c == ')' || c == ']' || c == '}';
    }
}
