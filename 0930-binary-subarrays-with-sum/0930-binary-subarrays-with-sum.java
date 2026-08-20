class Solution {
    public int f(int[]nums,int goal){
        int left=0,count=0,sum=0,n=nums.length;
        for(int right=0;right<n;right++){
            sum+=nums[right];
            while(left<=right&&sum>goal){
                sum-=nums[left];
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return f(nums,goal)-f(nums,goal-1);
    }
}