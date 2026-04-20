class Solution {
    public int f(int row, int col, int m, int n, List<List<Integer>> triangle, int[][] dp) {
        if (col < 0 || col > n - 1)
            return (int) 1e9;
        if (row == m - 1) {
            return triangle.get(row).get(col);
        }
        if (dp[row][col] != -1)
            return dp[row][col];
        int same = triangle.get(row).get(col) + f(row + 1, col, m, n, triangle, dp);
        int next = triangle.get(row).get(col) + f(row + 1, col + 1, m, n, triangle, dp);
        return dp[row][col] = Math.min(same, next);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diag = triangle.get(i).get(j) + dp[i + 1][j+1];
                dp[i][j]=Math.min(down,diag);
            }
        }
        return dp[0][0];
    }
}