class Node{
    int key,val;
    Node next;
    Node prev;
    public Node(int k,int v){
        this.key=k;
        this.val=v;
        this.next=null;
        this.prev=null;
    }
}
class LRUCache {
    HashMap<Integer,Node> map;
    int n;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        n=capacity;
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        removeNode(node);
        insertAtHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            removeNode(node);
            Node temp=new Node(key,value);
            insertAtHead(temp);
            map.put(key,temp);
            return;
        }
        if(map.size()==n){
            Node node=tail.prev;
            removeNode(node);
            map.remove(node.key);
            Node temp=new Node(key,value);
            insertAtHead(temp);
            map.put(key,temp);
            return;
        }
        Node temp=new Node(key,value);
        insertAtHead(temp);
        map.put(key,temp);
    }
    public void insertAtHead(Node node){
        node.next=head.next;
        head.next.prev=node;
        node.prev=head;
        head.next=node;
    }
    public void removeNode(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */