class Solution {
    private class Graph {
        Map<Integer, List<int[]>> adjList;

        public Graph() {
            this.adjList = new HashMap<>();
        }

        public void addNode(int n, int m, int weight) {
            if (!this.adjList.containsKey(n)) {
                this.adjList.put(n, new ArrayList<>());
            }

            this.adjList.get(n).add(new int[]{m, weight});
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Graph graph = new Graph();

        for (int[] time : times) {
            graph.addNode(time[0], time[1], time[2]);
        }

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k - 1] = 0;

        Comparator<int[]> c = (a, b) -> a[1] - b[1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(c);
        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int node = curr[0];
            int distance = curr[1];

            if (distance > distances[node - 1]) continue;

            for (int[] neighbor : graph.adjList.getOrDefault(curr[0], new ArrayList<>())) {
                int neighborNode = neighbor[0];
                int weight = neighbor[1];

                if (distances[node - 1] + weight < distances[neighborNode - 1]) {
                    distances[neighborNode - 1] = distances[node - 1] + weight;
                    pq.add(new int[]{neighborNode, distances[neighborNode - 1]});
                }
            }
        }

        int result = 0;
        for (int i = 0; i < distances.length; i ++) {
            if (distances[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, distances[i]);
        }

        return result;
    }
}
