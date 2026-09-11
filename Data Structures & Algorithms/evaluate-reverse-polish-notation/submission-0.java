class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length < 3) {
            return Integer.parseInt(tokens[0]);
        }

        int result = calculate(tokens[0], tokens[1], tokens[2]);
        for (int i = 3; i < tokens.length; i += 2) {
            result = calculate(result + "", tokens[i], tokens[i + 1]);
        }

        return result;
    }

    private int calculate(String a, String b, String c) {
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        switch(c) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
        }
        return 0;
    }
}
