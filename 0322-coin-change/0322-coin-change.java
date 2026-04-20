class Solution {
    int f(int i,int amt,int[]coins){
        if(i==0){
            if(amt%coins[i]==0) return amt/coins[0];
            else return (int)1e9;
        }
        int notTake=f(i-1,amt,coins);
        int take=(int)1e9;
        if(coins[i]<=amt){
            take=1+f(i,amt-coins[i],coins);
        }
        return Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length,m=amount+1;
        int[][]dp=new int[n][m];
        for(int i=0;i<m;i++){
            if(i%coins[0]==0) dp[0][i]=i/coins[0];
            else dp[0][i]=(int)1e9;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int notTake=dp[i-1][j];
                int take=(int)1e9;
                if(coins[i]<=j){
                    take=1+dp[i][j-coins[i]];
                }
                dp[i][j]=Math.min(take,notTake);
            }
        }
        return dp[n-1][amount]>=(int)1e9?-1:dp[n-1][amount];
    }
}