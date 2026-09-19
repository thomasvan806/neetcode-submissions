class KthLargest {
    PriorityQueue<Integer> q;
    int size;
    int max;

    public KthLargest(int k, int[] nums) {
        this.q = new PriorityQueue<>(k);
        this.size = 0;
        this.max = k;
        for (int i : nums) {
            this.add(i);
        }
    }

    public int add(int val) {
        if (this.size < this.max) {
            q.add(val);
            this.size ++;
        } else if (q.peek() < val) {
            q.poll();
            q.add(val);
        }

        return q.peek();
    }
}
