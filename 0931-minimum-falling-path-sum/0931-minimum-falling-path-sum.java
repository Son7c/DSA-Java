class Solution {
    public int f(int i, int j, int[][] matrix, int m, int n, int[][] dp) {
        if (i >= m || j < 0 || j >= n)
            return (int) 1e9;
        if (i == m - 1)
            return matrix[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int a = matrix[i][j] + f(i + 1, j - 1, matrix, m, n, dp);
        int b = matrix[i][j] + f(i + 1, j, matrix, m, n, dp);
        int c = matrix[i][j] + f(i + 1, j + 1, matrix, m, n, dp);
        return dp[i][j] = Math.min(a, Math.min(b, c));
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = matrix[m - 1][i];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int a=(int)1e9,b=(int)1e9,c=(int)1e9;
                if(j>0&&i<m-1) a = matrix[i][j] + dp[i + 1][j - 1];
                if(i<m-1&&j<n)b = matrix[i][j] + dp[i + 1][j];
                if(j<n-1&&i<m-1)c = matrix[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(a, Math.min(b, c));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            min=Math.min(dp[0][i],min);
        }
        return min;
    }
}