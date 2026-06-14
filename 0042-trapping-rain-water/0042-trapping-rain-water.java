class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n<=2) return 0;
        Stack<Integer> st=new Stack<>();
        int[] nge=new int[n];
        int[] pge=new int[n];
        nge[n-1]=-1;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty()&&height[st.peek()]<=height[i]) st.pop();
            if(st.isEmpty()){
                nge[i]=-1;
                st.push(i);
                continue;
            }
            if(height[st.peek()]>height[i]&&nge[st.peek()]!=-1) nge[i]=nge[st.peek()];
            else nge[i]=st.peek();
            st.push(i);
        }
        st.clear();
        pge[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty()&&height[st.peek()]<=height[i]) st.pop();
            if(st.isEmpty()){
                pge[i]=-1;
                st.push(i);
                continue;
            }
            if(height[st.peek()]>height[i]&&pge[st.peek()]!=-1) pge[i]=pge[st.peek()];
            else pge[i]=st.peek();
            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(nge[i]==-1||pge[i]==-1){
                ans+=0;
                continue;
            }
            int waterLevel=Math.min(height[nge[i]],height[pge[i]]);
            ans+=waterLevel-height[i];
        }
        return ans;
    }
}