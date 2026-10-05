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
            if (!this.adjList.containsKey(m)) {
                this.adjList.put(m, new ArrayList<>());
            }
            this.adjList.get(m).add(n);
        }
    }

    public boolean validTree(int n, int[][] edges) {
        Graph graph = new Graph();

        for (int[] edge : edges) {
            graph.addNode(edge[0], edge[1]);
        }

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i ++) {
            if (!visited.contains(i)) {
                if (cycle(graph, i, -1, visited)) return false;
            }
        }

        return edges.length == n - 1;
    }

    private boolean cycle(Graph graph, int curr, int parent, Set<Integer> visited) {
        if (visited.contains(curr)) {
            return true;
        }
        visited.add(curr);
        for (int neighbor : graph.adjList.getOrDefault(curr, new ArrayList<>())) {
            if (neighbor != parent) {
                if (cycle(graph, neighbor, curr, visited)) return true;
            }
        }
        return false;
    }
}
