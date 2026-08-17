class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nse=new int[n];
        int[] pse=new int[n];
        int min=Integer.MAX_VALUE;
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i]) st.pop();
            if(st.isEmpty()){
                nse[i]=n;
            }else nse[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i]) st.pop();
            if(st.isEmpty()){
                pse[i]=-1;
            }else pse[i]=st.peek();
            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,heights[i]*(nse[i]-pse[i]-1));
        }
        return ans;
    }
}