class Solution {
    public int f(int[] piles,int left,int right,Integer[][] dp){
        if(left>right) return 0;
        if(left==right) return piles[left];
        if(dp[left][right]!=null) return dp[left][right];

        int a=piles[left]+f(piles,left+1,right,dp);
        int b=piles[right]+f(piles,left,right-1,dp);

        return dp[left][right]=Math.max(a,b);
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        Integer [][]dp =new Integer[n][n];
        return f(piles,0,n-1,dp)>=0;
    }
}