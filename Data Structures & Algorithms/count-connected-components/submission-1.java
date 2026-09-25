class Solution {
    private class Graph {
        public Map<Integer, List<Integer>> adjList;

        public Graph() {
            adjList = new HashMap<>();
        }

        public void addNode(int n, int m) {
            if (!adjList.containsKey(n)) {
                adjList.put(n, new ArrayList<>());
            }
            adjList.get(n).add(m);
            if (!adjList.containsKey(m)) {
                adjList.put(m, new ArrayList<>());
            }
            adjList.get(m).add(n);
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        Graph graph = new Graph();

        for (int i = 0; i < edges.length; i ++) {
            graph.addNode(edges[i][0], edges[i][1]);
        }

        Set<Integer> visited = new HashSet<>();
        int result = 0;
        for (int i = 0; i < n; i ++) {
            if (!graph.adjList.containsKey(i)) {
                result ++;
            } else if (!visited.contains(i)) {
                dfs(graph, visited, i);
                result ++;
            }
        }

        return result;
    }

    private void dfs(Graph graph, Set<Integer> visited, int i) {
        if (visited.contains(i)) return;
        visited.add(i);

        for (int neighbor : graph.adjList.get(i)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}
