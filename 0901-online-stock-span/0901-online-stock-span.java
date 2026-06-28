class Pair{
    int val,idx;
    public Pair(int v,int i){
        this.val=v;
        this.idx=i;
    }
}
class StockSpanner {
    Stack<Pair> st;
    int idx;
    public StockSpanner() {
        st=new Stack<>();
        idx=0;
    }
    
    public int next(int price) {
        int i=idx;
        if(idx==0){
            st.push(new Pair(price,0));
            idx++;
            return 1;
        }
        while(!st.isEmpty()&&st.peek().val<=price){
            i=st.pop().idx;
        }
        int val=idx-i+1;
        st.push(new Pair(price,i));
        idx++;
        return val;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */