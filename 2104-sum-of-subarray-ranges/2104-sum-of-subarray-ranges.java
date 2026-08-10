class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;

        //Sum of Subarray minimum
        int[] nse=new int[n];
        int[] pse=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&nums[st.peek()]>=nums[i]) st.pop();
            if(st.isEmpty()){
                nse[i]=n;
            }
            else nse[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&nums[st.peek()]>nums[i]) st.pop();
            if(st.isEmpty()){
                pse[i]=-1;
            }else pse[i]=st.peek();
            st.push(i);
        }
        st.clear();
        long min=0l;
        for(int i=0;i<n;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            min+=(long) right*left*nums[i];
        }

        //Sum of Subarray Maximum
        int[] nge=new int[n];
        int[] pge=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&nums[st.peek()]<=nums[i]) st.pop();
            if(st.isEmpty()){
                nge[i]=n;
            }
            else nge[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&nums[st.peek()]<nums[i]) st.pop();
            if(st.isEmpty()){
                pge[i]=-1;
            }else pge[i]=st.peek();
            st.push(i);
        }
        long max=0l;
        for(int i=0;i<n;i++){
            int left=i-pge[i];
            int right=nge[i]-i;
            max+=(long) right*left*nums[i];
        }
        return max-min;
    }
}