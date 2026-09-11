class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> expression = new Stack<>();
        for (int i = 0; i < tokens.length; i ++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") ||
                tokens[i].equals("*") || tokens[i].equals("/")) {
                String second = expression.pop();
                expression.push(calculate(expression.pop(), second, tokens[i]));
            } else {
                expression.push(tokens[i]);
            }
        }
        return Integer.parseInt(expression.pop());
    }

    private String calculate(String a, String b, String c) {
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        switch(c) {
            case "+":
                return x + y + "";
            case "-":
                return x - y + "";
            case "*":
                return x * y + "";
            case "/":
                return x / y + "";
        }
        return "";
    }
}
