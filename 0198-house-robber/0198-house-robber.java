class Solution {
    public int fn(int[] nums,int n,int[]dp){
        if(n==0) return nums[n];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];

        int pick=nums[n]+fn(nums,n-2,dp);
        int notPick=0+fn(nums,n-1,dp);
        return dp[n]=Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp, -1);
        return fn(nums,nums.length-1,dp);
    }
}