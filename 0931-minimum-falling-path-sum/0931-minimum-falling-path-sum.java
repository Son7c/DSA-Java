class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = matrix[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                int c = Integer.MAX_VALUE;
                if (i < n - 1 && j < n - 1) {
                    a = matrix[i][j] + dp[i + 1][j + 1];
                }
                if (i < n - 1 && j < n) {
                    b = matrix[i][j] + dp[i + 1][j];
                }
                if (i < n - 1 && j > 0) {
                    c = matrix[i][j] + dp[i + 1][j - 1];
                }
                dp[i][j] = Math.min(a, Math.min(b, c));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[0][i]);
        }
        return ans;
    }
}