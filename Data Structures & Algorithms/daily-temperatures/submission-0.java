class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       //  30,38,30,36,35,40,28
       //   1,
        int[] result = new int[temperatures.length];
        Stack<Integer> temps = new Stack<>();
        Stack<Integer> indices = new Stack<>();
        
        for (int i = 0; i < temperatures.length; i ++) {
            if (temps.isEmpty() || temperatures[i] <= temps.peek()) {
                temps.push(temperatures[i]);
                indices.push(i);
            } else {
                while (!temps.isEmpty() && temps.peek() < temperatures[i]) {
                    temps.pop();
                    int index = indices.pop();
                    result[index] = i - index;
                }
                temps.push(temperatures[i]);
                indices.push(i);
            }
        }
        return result;
    }
}
