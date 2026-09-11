class MinStack {
    private Stack<Integer> elements;
    private Stack<Integer> min;

    public MinStack() {
        elements = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        elements.push(val);
        if (min.isEmpty()) {
            min.push(val);
        } else {
            min.push(Math.min(val, min.peek()));
        }
    }
    
    public void pop() {
        elements.pop();
        min.pop();
    }
    
    public int top() {
        return elements.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
