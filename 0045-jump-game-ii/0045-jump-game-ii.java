class Solution {
    // public int f(int[] nums, int idx) {
    //     if (idx == nums.length - 1)
    //         return 0;
    //     int jump = Integer.MAX_VALUE;
    //     for (int i = 1; i <= nums[idx] && i + idx < nums.length; i++) {
    //         int ans = f(nums, i + idx);
    //         if (ans != Integer.MAX_VALUE)
    //             jump = Math.min(jump, 1 + ans);
    //     }
    //     return jump;
    // }

    public int jump(int[] nums) {
        // return f(nums, 0);

        //Tabulation
        // int n = nums.length;
        // int[] dp = new int[n];
        // dp[n-1]=0;
        // for (int i = n - 2; i >= 0; i--) {
        //     int jump=Integer.MAX_VALUE;
        //     for (int j = 1; j <= nums[i] && j + i < n; j++) {
        //         int ans = dp[j+i];
        //         if (ans != Integer.MAX_VALUE)
        //             jump = Math.min(jump, 1 + ans);
        //     }
        //     dp[i]=jump;
        // }
        // return dp[0];

        //Greedy
        int l=0,r=0,jumps=0,n=nums.length;
        while(r<n-1){
            int farthest=0;
            for(int i=l;i<=r;i++){
                farthest=Math.max(farthest,i+nums[i]);
            }
            l=r+1;
            r=farthest;
            jumps++;
        }
        return jumps;
    }
}