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

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph();

        for (int[] course : prerequisites) {
            graph.addNode(course[1], course[0]);
        }

        int[] indegrees = new int[numCourses];

        for (int i = 0; i < indegrees.length; i ++) {
            for (int neighbors : graph.adjList.getOrDefault(i, new ArrayList<>())) {
                indegrees[neighbors]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegrees.length; i ++) {
            if (indegrees[i] == 0) queue.add(i);
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.remove();
            topoOrder.add(node);

            for (int neighbor : graph.adjList.getOrDefault(node, new ArrayList<>())) {
                if (--indegrees[neighbor] == 0) queue.add(neighbor);
            }
        }

        if (topoOrder.size() == numCourses) {
            int[] result = new int[numCourses];
            for (int i = 0; i < topoOrder.size(); i ++) {
                result[i] = topoOrder.get(i);
            }
            return result;
        } else {
            return new int[0];
        }
    }
}
