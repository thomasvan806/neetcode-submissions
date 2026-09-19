class Solution {
    public int findKthLargest(int[] nums, int k) {
        Comparator<Integer> c = (a, b) -> b - a;
        PriorityQueue<Integer> q = new PriorityQueue<>(nums.length, c);

        for (int i : nums) {
            q.add(i);
        }

        for (int i = 0; i < k - 1; i ++) {
            q.remove();
        }

        return q.peek();
    }
}
