class Solution {
    public int largestRectangleArea(int[] nums) {
        int n=nums.length;
        int[] nse=new int[n];
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();
        nse[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty()&&nums[st.peek()]>=nums[i]) st.pop();
            if(st.isEmpty()){
                nse[i]=n;
                st.push(i);
                continue;
            }
            nse[i]=st.peek();
            st.push(i);
        }
        st.clear();
        pse[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty()&&nums[st.peek()]>=nums[i]) st.pop();
            if(st.isEmpty()){
                pse[i]=-1;
                st.push(i);
                continue;
            }
            pse[i]=st.peek();
            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,(nse[i]-pse[i]-1)*nums[i]);
        }
        return ans;
    }
}