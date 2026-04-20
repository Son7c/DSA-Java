class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length/2;
        int[]pos=new int[n];
        int[]neg=new int[n];
        int idx1=0,idx2=0;
        for(int i:nums){
          if(i>0) pos[idx1++]=i;
          else neg[idx2++]=i;
        }
        idx1=0;idx2=0;
        int i=0;
        while(idx1!=n&&idx2!=n){
          nums[i++]=pos[idx1++];
          nums[i++]=neg[idx2++];
        }
        return nums;
    }
}