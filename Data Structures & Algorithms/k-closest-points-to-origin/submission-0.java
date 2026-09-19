class Solution {
    class PointComparator implements Comparator<int[]> {
        private double distanceFromOrigin(int[] p) {
            return Math.sqrt((p[0] * p[0]) + (p[1] * p[1]));
        }
        
        public int compare(int[] p1, int[] p2) {
            double diff = distanceFromOrigin(p1) - distanceFromOrigin(p2);
            if (diff < 0) {
                return -1;
            } if (diff == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue(points.length, new PointComparator());

        for (int[] p : points) {
            q.add(p);
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i ++) {
            res[i] = q.poll();
        }

        return res;
    }
}
