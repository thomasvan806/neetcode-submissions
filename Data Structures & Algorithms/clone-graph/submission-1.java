/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }

    private Node dfs(Node curr, Map<Node, Node> seen) {
        if (curr == null) return null;

        if (seen.containsKey(curr)) {
            return seen.get(curr);
        } else {
            Node newNode = new Node(curr.val);
            seen.put(curr, newNode);
            for (Node neighbor : curr.neighbors) {
                newNode.neighbors.add(dfs(neighbor, seen));
            }
            return newNode;
        }
    }
}