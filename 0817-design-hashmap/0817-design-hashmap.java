class MyHashMap {
    class Node{
        int key,value;
        public Node(int k,int v){
            this.key=k;
            this.value=v;
        }
    }
    private int n;
    private int N;
    private LinkedList<Node>[]buckets;
    public MyHashMap() {
        this.N=4;
        this.buckets=new LinkedList[4];
        for(int i=0;i<4;i++) buckets[i]=new LinkedList<>();
        this.n=0;
    }
    public int hashFunction(int key){
        int bi=Integer.hashCode(key);
        return Math.abs(bi)%N;
    }
    public int searchinLL(int key,int bi){
        LinkedList<Node> ll=buckets[bi];
        for(int i=0;i<ll.size();i++){
            if(ll.get(i).key==key) return i;
        }
        return -1;
    }
    public void put(int key, int value) {
        int bi=hashFunction(key);
        int di=searchinLL(key,bi);
        if(di==-1){
            buckets[bi].add(new Node(key,value));
            n++;
        }else{
            Node node=buckets[bi].get(di);
            node.value=value;
        }
        double lambda=(double)n/N;
        if(lambda>2.0) rehash();
    }
    public void rehash(){
        LinkedList<Node>[]oldBuckets=buckets;
        N=N*2;
        buckets=new LinkedList[N];
        for(int i=0;i<N;i++) buckets[i]=new LinkedList<>();
        n=0;

        for(int i=0;i<oldBuckets.length;i++){
            LinkedList<Node> ll=oldBuckets[i];
            for(int j=0;j<ll.size();j++){
                Node node=oldBuckets[i].get(j);
                put(node.key,node.value);
            }
        }
    }
    public int get(int key) {
        int bi=hashFunction(key);
        int di=searchinLL(key,bi);
        if(di==-1) return -1;
        else{
            return buckets[bi].get(di).value;
        }
    }
    
    public void remove(int key) {
        int bi=hashFunction(key);
        int di=searchinLL(key,bi);
        if(di!=-1) buckets[bi].remove(di);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */