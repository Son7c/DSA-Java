class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][]dp=new int[n][amount+1];
        for(int i=0;i<n;i++) dp[i][0]=1;
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notPick=dp[i-1][j];
                int pick=0;
                if(coins[i]<=j){
                    pick=dp[i][j-coins[i]];
                }
                dp[i][j]=pick+notPick;
            }
        }
        return dp[n-1][amount];
    }
}