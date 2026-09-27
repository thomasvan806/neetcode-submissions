class Solution {
    private class Graph {
        public Map<Integer, List<Integer>> adjList;

        public Graph() {
            this.adjList = new HashMap<>();
        }

        public void addNode(int n, int m) {
            if (!this.adjList.containsKey(n)) {
                this.adjList.put(n, new ArrayList<>());
            }
            this.adjList.get(n).add(m);
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph();

        for (int[] set : prerequisites) {
            graph.addNode(set[1], set[0]);
        }

        for (int i = 0; i < numCourses; i ++) {
            if (!graph.adjList.containsKey(i)) graph.adjList.put(i, new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int parent : graph.adjList.keySet()) {
            for (int child : graph.adjList.get(parent)) {
                indegree[child]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i ++) {
            if (indegree[i] == 0) queue.add(i);
        }

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.remove();
            order.add(node);

            for (int neighbor : graph.adjList.get(node)) {
                if (--indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return order.size() == numCourses;
    }
}
