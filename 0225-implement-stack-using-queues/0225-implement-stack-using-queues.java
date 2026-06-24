class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        if(q2.isEmpty()){
            q1.add(x);
        }else{
            q1.add(x);
        }
    }
    
    public int pop() {
        if(!q1.isEmpty()){
            while(q1.size()>1) q2.add(q1.remove());
            return q1.remove();
        }
        if(!q2.isEmpty()){
            while(q2.size()>1) q1.add(q2.remove());
            return q2.remove();
        }
        return -1;
    }
    
    public int top() {
        if(!q1.isEmpty()){
            while(q1.size()>1) q2.add(q1.remove());
            int top=q1.peek();
            q2.add(q1.remove());
            return top;
        }
        if(!q2.isEmpty()){
            while(q2.size()>1) q1.add(q2.remove());
            int top=q2.peek();
            q1.add(q2.remove());
            return top;
        }
        return -1;
    }
    
    public boolean empty() {
        return q1.isEmpty()&&q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */