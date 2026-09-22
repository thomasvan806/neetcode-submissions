class WordDictionary {
    private class Node {
        public Node[] children;
        public boolean isWordEnd;

        public Node() {
            children = new Node[26];
            isWordEnd = false;
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i ++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.isWordEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int i, Node curr) {
        if (curr == null) return false;
        if (i == word.length()) return curr.isWordEnd;

        if (word.charAt(i) == '.') {
            boolean res = false;
            for (Node n : curr.children) {
                res = res || search(word, i + 1, n);
            }
            return res;
        } else {
            return search(word, i + 1, curr.children[word.charAt(i) - 'a']);
        }
    }
}
