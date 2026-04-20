class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> map;

    public void deleteNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    public void insertAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        deleteNode(node);
        insertAtHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            insertAtHead(node);
            return;
        }
        if (map.size() == capacity) {
            Node lru=tail.prev;
            map.remove(tail.prev.key);
            deleteNode(lru);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAtHead(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */