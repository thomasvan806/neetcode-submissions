class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i ++) {
            char currChar = s.charAt(i);
            if (isOpenParentheses(currChar)) {
                stack.push(currChar);
            } else {
                if (stack.isEmpty() || !parenthesesMatch(stack.pop(), currChar)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpenParentheses(char a) {
        return a == '(' || a == '{' || a == '[';
    }

    private boolean parenthesesMatch(char a, char b) {
        return a == '(' && b == ')' || a == '{' && b =='}' || a == '[' && b == ']';
    }
}
