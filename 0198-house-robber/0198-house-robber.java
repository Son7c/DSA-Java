class Solution {
    public int f(int n,int[] nums,int[] dp){
        if(n==0) return nums[n];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];

        int leave=nums[n]+f(n-2,nums,dp);
        int noLeave=0+f(n-1,nums,dp);

        return dp[n]=Math.max(leave,noLeave);
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return f(nums.length-1,nums,dp);
    }
}