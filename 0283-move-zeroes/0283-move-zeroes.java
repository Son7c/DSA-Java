class Solution {
    public void moveZeroes(int[] nums) {
        int idx=0,count=0,n=nums.length;
        for(int i:nums){
          if(i!=0)count++;
        }
        for(int i=0;i<n;i++){
          if(nums[i]!=0) nums[idx++]=nums[i];
        }
        while(idx!=n){
          nums[idx++]=0;
        }
    }
}