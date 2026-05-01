class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      Stack<Integer> st=new Stack<>();
      int n=temperatures.length;
      st.push(n-1);
      int res[]=new int[n];
      res[n-1]=-1;
      for(int i=n-1;i>=0;i--){
        while(!st.isEmpty()&&temperatures[st.peek()]<=temperatures[i]) st.pop();
        if(st.isEmpty()){
            res[i]=-1;
        }else{
            res[i]=st.peek();
        }
        st.push(i);
      }
      for(int i=0;i<n;i++){
        if(res[i]==-1) res[i]=0;
        else res[i]=res[i]-i;
      }
      return res;
    }
}