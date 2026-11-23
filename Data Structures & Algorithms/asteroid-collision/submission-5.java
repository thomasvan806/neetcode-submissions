class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Stack
        // add to stack
        // ignore negative numbers in beginning, and positive numbers at the end
        // 2
        // 
        // 
        // if stack empty, ignore negative numbers
        Stack<Integer> stack = new Stack<>();

        // only pop on negative
        for (int i : asteroids) {
            if (i < 0) {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(i);
                } else {
                    int currAsteroid = stack.peek();
                    boolean equal = false;
                    while (!stack.isEmpty() && (stack.peek() > 0) && (i * -1) >= currAsteroid) {
                        stack.pop();
                        if (i * -1 == currAsteroid) {
                            equal = true;
                            break;
                        }
                        if (!stack.isEmpty()) currAsteroid = stack.peek();
                    }

                    if (!equal) {
                        if (stack.isEmpty() || stack.peek() < 0) {
                            stack.push(i);
                        } else {
                        }
                    }
                }
            } else {
                stack.push(i);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i --) {
            result[i] = stack.pop();
        }

        return result;
    }
}