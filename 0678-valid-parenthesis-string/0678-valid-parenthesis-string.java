class Solution {
    public boolean f(String s, int idx, int ct) {
        if (idx == s.length()) {
            return ct == 0;
        }
        if (ct < 0)
            return false;
        if (s.charAt(idx) == '(')
            return f(s, idx + 1, ct + 1);
        else if (s.charAt(idx) == ')')
            return f(s, idx + 1, ct - 1);
        return f(s, idx + 1, ct + 1) || f(s, idx + 1, ct - 1) || f(s, idx + 1, ct);
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[n][0] = true;
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int ct = 0; ct <= n; ct++) {
                if (s.charAt(idx) == '(') {
                    if (ct + 1 <= n)
                        dp[idx][ct] = dp[idx + 1][ct + 1];
                } else if (s.charAt(idx) == ')') {
                    if (ct - 1 >= 0)
                        dp[idx][ct] = dp[idx + 1][ct - 1];
                } else {
                    dp[idx][ct] = ct+1<=n&& dp[idx + 1][ct + 1] ||ct-1>=0&& dp[idx + 1][ct - 1] || dp[idx + 1][ct];
                }
            }
        }
        return dp[0][0];
    }
}