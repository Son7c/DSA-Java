class Solution {
    int f(int idx,int[] coins,int amt,int[][]dp){
        if(idx==0){
            if(amt%coins[idx]==0) return amt/coins[0];
            else return (int)1e9;
        }
        if (amt == 0) return 0;
        if(dp[idx][amt]!=-1) return dp[idx][amt];
        int notTake=f(idx-1,coins,amt,dp);
        int take=(int)1e9;
        if(coins[idx]<=amt){
            take=1+f(idx,coins,amt-coins[idx],dp);
        }
        return dp[idx][amt]=Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int[][]dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int val=f(coins.length-1,coins,amount,dp);
        return val>=(int)1e9?-1:val;
    }
}