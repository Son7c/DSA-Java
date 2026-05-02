class Pair{
    int idx,price;
    public Pair(int i,int p){
        this.idx=i;
        this.price=p;
    }
}
class StockSpanner {
    Stack<Pair> st;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        int count=0;
        while(!st.isEmpty()&&st.peek().price<=price){
            count+=st.pop().idx;
        }
        st.push(new Pair(count+1,price));
        return count+1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */