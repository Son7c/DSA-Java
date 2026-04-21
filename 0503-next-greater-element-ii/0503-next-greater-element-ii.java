class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int nums2[]=new int[n*2];
        int ans[]=new int[n];
        Stack<Integer> st=new Stack();
        for(int i=0;i<n*2;i++){
            nums2[i]=nums[i%n];
        }
        st.push(nums[n-1]);
        for(int i=(n*2)-2;i>=0;i--){
            if(st.peek()>nums2[i]){
                if(i<n) ans[i]=st.peek();
            }else{
                while(!st.isEmpty()&&st.peek()<=nums2[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    if(i<n) ans[i]=-1;
                }else{
                    if(i<n) ans[i]=st.peek();
                }
            }
            st.push(nums2[i]);
        }
        return ans;
    }
}