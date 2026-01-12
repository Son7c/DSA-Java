class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack <Integer> st= new Stack<>();
        int[] nge=new int[temperatures.length];
        int[] ans=new int[nge.length];
        for(int i=temperatures.length-1;i>=0;i--){
            if(st.isEmpty()){
                st.push(i);
                nge[i]=i;
            }else{
                while(!st.isEmpty()&&temperatures[st.peek()]<=temperatures[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    st.push(i);
                    nge[i]=st.peek();
                }else{
                    nge[i]=st.peek();
                    st.push(i);
                }
            }
        }
        for(int i=0;i<nge.length;i++){
            ans[i]=nge[i]-i;
        }
        return ans;
    }
}