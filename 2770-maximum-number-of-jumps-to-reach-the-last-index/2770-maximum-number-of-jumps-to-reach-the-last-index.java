class Solution {
    public int f(int idx, int target, int[] nums) {
        if (idx == nums.length - 1)
            return 0;
        int result = Integer.MIN_VALUE;
        for (int j = idx + 1; j < nums.length; j++) {
            if (Math.abs(nums[j] - nums[idx]) <= target) {
                int temp = 1 + f(j, target, nums);
                result = Math.max(result, temp);
            }
        }
        return result;
    }

    public int maximumJumps(int[] nums, int target) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int n = nums.length;
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) <= target&&dp[j]!=Integer.MIN_VALUE) {
                    int temp = 1 + dp[j];
                    dp[i] = Math.max(dp[i], temp);
                }
            }
        }
        return dp[0]<0?-1:dp[0];
    }
}