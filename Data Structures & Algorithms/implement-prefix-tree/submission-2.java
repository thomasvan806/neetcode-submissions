class PrefixTree {
    private class Node {
        public Node[] children;
        public boolean isWordEnd;

        public Node() {
            this.children = new Node[26];
            this.isWordEnd = isWordEnd;
        }
    }

    private Node root;

    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i ++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) curr.children[index] = new Node();
            curr = curr.children[index];
        }
        curr.isWordEnd = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i ++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return curr.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i ++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return true;
    }
}
