class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums) sum+=i;
        if((sum-target)%2!=0 || (sum-target)<0) return 0;
        target=(sum-target)/2;
        int n=nums.length;
        int[][]dp=new int[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        if(nums[0]==0) dp[0][0]=2;
        else if(nums[0]!=0 && nums[0]<=target) dp[0][nums[0]]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int notPick=dp[i-1][j];
                int pick=0;
                if(nums[i]<=j){
                    pick=dp[i-1][j-nums[i]];
                }
                dp[i][j]=pick+notPick;
            }
        }
        return dp[n-1][target];
    }
}