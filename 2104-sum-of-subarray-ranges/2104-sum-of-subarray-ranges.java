class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        int[]nse=new int[n];
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        nse[n-1]=n;
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
        pse[0]=-1;
        st.clear();
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty()&&nums[st.peek()]>nums[i]) st.pop();
            if(st.isEmpty()){
                pse[i]=-1;
                st.push(i);
                continue;
            }
            pse[i]=st.peek();
            st.push(i);
        }
        long smaller=0;
        for(int i=0;i<n;i++){
            int right=nse[i]-i;
            int left=i-pse[i];
            smaller+=(long)right*left*nums[i];
        }
        st.clear();
        int nge[]=new int[n];
        int pge[]=new int[n];
        nge[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty()&&nums[st.peek()]<=nums[i]) st.pop();
            if(st.isEmpty()){
                nge[i]=n;
                st.push(i);
                continue;
            }
            nge[i]=st.peek();
            st.push(i);
        }
        st.clear();
        pge[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty()&&nums[st.peek()]<nums[i]) st.pop();
            if(st.isEmpty()){
                pge[i]=-1;
                st.push(i);
                continue;
            }
            pge[i]=st.peek();
            st.push(i);
        }
        long larger=0;
        for(int i=0;i<n;i++){
            int right=nge[i]-i;
            int left=i-pge[i];
            larger+=(long)right*left*nums[i];
        }
        return larger-smaller;
    }
}