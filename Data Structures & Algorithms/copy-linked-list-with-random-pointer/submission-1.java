/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap<>();

        return copyRandomList(head, oldToNew);
    }

    private Node copyRandomList(Node curr, Map<Node, Node> oldToNew) {
        if (curr == null) return null;

        Node newNode;
        if (oldToNew.containsKey(curr)) {
            newNode = oldToNew.get(curr);
        } else {
            newNode = new Node(curr.val);
        }

        oldToNew.put(curr, newNode);
        if (curr.random == null) {
            newNode.random = null;
        } else if (!oldToNew.containsKey(curr.random)) {
            Node newRandom = new Node(curr.random.val);
            oldToNew.put(curr.random, newRandom);
            newNode.random = newRandom;
        } else {
            newNode.random = oldToNew.get(curr.random);
        }
        
        newNode.next = copyRandomList(curr.next, oldToNew);
        return newNode;
    }
}
