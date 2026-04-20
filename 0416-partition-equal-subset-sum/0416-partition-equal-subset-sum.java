class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        for(int i:nums){
            sum+=i;
        }
        int target=sum/2;
        if(sum%2!=0) return false;
        boolean[][]dp=new boolean[nums.length][target+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(nums[0]<=target) dp[0][nums[0]]=true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean notTake=dp[i-1][j];
                boolean take=false;
                if(j>=nums[i]){
                    take=dp[i-1][j-nums[i]];
                }
                dp[i][j]=take||notTake;
            }
        }
        return dp[n-1][target];
    }
}