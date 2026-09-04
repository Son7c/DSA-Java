class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] pge=new int[n];
        int[] nse=new int[n];
        //nse
        int min=nums[n-1];
        nse[n-1]=min;
        for(int i=n-2;i>=0;i--){
            min=Math.min(min,nums[i]);
            nse[i]=min;
        }
        int max=nums[0];
        pge[0]=max;
        for(int i=1;i<n;i++){
            max=Math.max(max,nums[i]);
            pge[i]=max;
        }
        for(int i=0;i<n;i++){
            int val=pge[i]-nse[i];
            if(val<=k){
                return i;
            }
        }
        return -1;
    }
}