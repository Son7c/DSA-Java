class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        String s2=sb.toString();
        int[][]dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            dp[0][i]=0;
            dp[i][0]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=0+Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int lp=dp[n][n];
        return s.length()-lp;
    }
}