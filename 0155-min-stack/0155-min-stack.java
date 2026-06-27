class Pair{
    int val,min;
    public Pair(int v,int m){
        this.val=v;
        this.min=m;
    }
}
class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int value) {
        if(st.isEmpty()||st.peek().min>=value){
            st.push(new Pair(value,value));
            return;
        }
        if(st.peek().min<value){
            Pair prev=st.peek();
            st.push(new Pair(value,prev.min));
            return;
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
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */