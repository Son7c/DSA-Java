class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack <Integer> st=new Stack();
        int n=nums2.length;
        int ans[]=new int[n];
        st.push(nums2[n-1]);
        ans[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            if(st.peek()>nums2[i]){
                ans[i]=st.peek();
                st.push(nums2[i]);
            }else{
                while(!st.isEmpty()&&st.peek()<=nums2[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i]=-1;
                    st.push(nums2[i]);
                }else{
                    ans[i]=st.peek();
                    st.push(nums2[i]);
                }
            }
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums2[i],ans[i]);
        }
        int[] res=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i]=map.get(nums1[i]);
        }
        return res;
    }
}