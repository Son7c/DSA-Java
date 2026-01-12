class MinStack {
    class Pair{
        int val;
        int min;
        public Pair(int v,int m){
            this.min=m;
            this.val=v;
        }
    }
    Stack<Pair> st;
    public MinStack() {
        st =new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val,val));
        }else{
            Pair prev=st.peek();
            st.push(new Pair(val,Math.min(prev.min,val)));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */