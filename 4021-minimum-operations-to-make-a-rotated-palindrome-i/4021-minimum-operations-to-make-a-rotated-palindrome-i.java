class Solution {
    public int minOperations(String s) {
        int ans = Integer.MAX_VALUE;
        int n = s.length();
        for (int k = 0; k < n; k++) {
            int curr = k;
            for (int i = 0; i < n / 2; i++) {
                int a = s.charAt((i + k) % n)-'a';
                int b = s.charAt((k + n - 1 - i)%n)-'a';
                int diff = Math.abs(a - b);
                curr += Math.min(diff,26-diff);
            }
            ans = Math.min(ans, curr);
        }
        return ans;
    }
}