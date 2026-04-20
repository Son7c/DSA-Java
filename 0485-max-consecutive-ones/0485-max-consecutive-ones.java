class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
    int n=nums.length;
    if(n==1) return nums[0]==1?1:0;
    int maxi=Math.max(nums[0],nums[1]);
    int[]dp=new int[n];
    dp[0]=nums[0]==1?1:0;
    for(int i=1;i<n;i++){
      if(nums[i]==1) dp[i]=1+dp[i-1];
      else dp[i]=0;
      maxi=Math.max(maxi,dp[i]);
    }
    return maxi;
  }
}