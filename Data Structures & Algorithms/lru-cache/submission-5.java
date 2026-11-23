class LRUCache {
    // underlying map of keys to values
    // doubly-linked list
    // 
    class Node {
        public int value;
        public Node next;
        public Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public int capacity;
    public int size;
    public Node head;
    public Node tail;
    public Map<Integer, Node> map;
    public Map<Node, Integer> valueToKey;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.valueToKey = new HashMap<>();
    }
    
    public int get(int key) {
        // search map for key
        // if exists, return value, and move to beginning of list
        // if not exists, return -1;
        if (!map.containsKey(key)) return -1;

        Node target = map.get(key);
        this.use(target);
        return target.value;
    }
    
    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node target = map.get(key);
            target.value = value;
            this.use(target);
        } else {
            if (this.size < this.capacity) {
                Node newNode = new Node(value);
                map.put(key, newNode);
                valueToKey.put(newNode, key);
                newNode.next = head;
                head = newNode;
                this.size ++;
                if (size > 1) head.next.prev = head;
                if (tail == null) tail = head;
            } else {
                int oldKey = valueToKey.get(tail);
                valueToKey.remove(tail);
                map.remove(oldKey);
                tail = tail.prev;
                if (this.size > 1) {
                    tail.next = null;
                }
                Node newNode = new Node(value);
                map.put(key, newNode);
                valueToKey.put(newNode, key);
                if (size == 1) head = null;
                newNode.next = head;
                head = newNode;
                if (size > 1) head.next.prev = head;
            }
        }
        // key exists
        // key does not exist
        // under capacity
        // at capacity
    }

    private void use(Node node) {
        if (this.head != node) {
            // at end
            if (node.next == null) {
                tail = node.prev;
                node.prev.next = null;
                node.prev = null;
                node.next = head;
                head = node;
                head.next.prev = head;
            } else {
                // in middle
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = null;
                node.next = head;
                head = node;
                head.next.prev = head;
            }
        }
    }
}
