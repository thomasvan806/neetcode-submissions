class Solution {
    public int lastStoneWeight(int[] stones) {
        Comparator<Integer> c = (a, b) -> b - a;
        PriorityQueue<Integer> q = new PriorityQueue<>(stones.length, c);

        for (int i : stones) {
            q.add(i);
        }

        while (q.size() > 1) {
            int y = q.poll();
            int x = q.poll();

            if ((y - x) > 0) {
                q.add(y - x);
            }
        }

        return q.isEmpty() ? 0 : q.poll();
    }
}
