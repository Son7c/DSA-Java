class Solution {
    public boolean f(int []nums,int idx,Boolean[] dp){
        if(idx==nums.length-1) return true;
        if(idx>nums.length) return false;
        if(dp[idx]!=null) return dp[idx];
        boolean ans=false;
        for(int i=1;i<=nums[idx];i++){
            ans=ans||f(nums,idx+i,dp);
        }
        return dp[idx]=ans;
    }
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        Boolean[] dp=new Boolean[nums.length];
        return f(nums,0,dp);
    }
}