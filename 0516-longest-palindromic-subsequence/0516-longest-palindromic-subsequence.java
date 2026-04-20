class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
        String s2=sb.reverse().toString();
        int n1=s.length(),n2=s2.length();
        int[][]dp=new int[n1+1][n2+1];
        for(int i=0;i<n1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<n2;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n1][n2];
    }
}