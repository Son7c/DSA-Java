class Solution {
    public int f(int row, int col, int count, int[][] coins) {
        if (row < 0 || col < 0)
            return (int) -1e9;
        if (row == 0 && col == 0) {
            if (coins[0][0] > 0)
                return coins[0][0];
            else {
                if (count <= 0) {
                    return coins[0][0];
                } else {
                    return 0;
                }
            }
        }
        int up = (int) -1e9, left = (int) -1e9;
        if (coins[row][col] >= 0) {
            up = coins[row][col] + f(row - 1, col, count, coins);
            left = coins[row][col] + f(row, col - 1, count, coins);
        } else {
            if (count <= 0) {
                up = coins[row][col] + f(row - 1, col, count, coins);
                left = coins[row][col] + f(row, col - 1, count, coins);
            } else {
                up = Math.max(f(row - 1, col, count - 1, coins), coins[row][col] + f(row - 1, col, count, coins));
                left = Math.max(f(row, col - 1, count - 1, coins), coins[row][col] + f(row, col - 1, count, coins));
            }
        }
        return Math.max(up, left);
    }

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        if (coins[0][0] > 0) {
            for (int i = 0; i <= 2; i++) {
                dp[0][0][i] = coins[0][0];
            }
        } else {
            dp[0][0][0] = coins[0][0];
            for (int i = 1; i <= 2; i++) {
                dp[0][0][i] = 0;
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0) continue;
                for (int count = 0; count <= 2; count++) {
                    int up = (int) -1e9, left = (int) -1e9;
                    if (coins[row][col] >= 0) {
                        if (row > 0) up = coins[row][col] + dp[row - 1][col][count];
                        if(col>0) left = coins[row][col] + dp[row][col - 1][count];
                    } else {
                        if (count <= 0) {
                            if (row > 0) up = coins[row][col] + dp[row - 1][col][count];
                            if(col>0) left = coins[row][col] + dp[row][col - 1][count];
                        } else {
                            if (row > 0) up = Math.max(dp[row - 1][col][count - 1],
                                    coins[row][col] + dp[row - 1][col][count]);
                            if(col>0) left = Math.max(dp[row][col - 1][count - 1],
                                    coins[row][col] + dp[row][col - 1][count]);
                        }
                    }
                    dp[row][col][count]=Math.max(up, left);
                }
            }
        }
        return dp[m-1][n-1][2];
    }
}