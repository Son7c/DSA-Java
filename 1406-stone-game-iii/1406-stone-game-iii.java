class Solution {
    // Commented part is Recursive

    // public int solve(int left,int[] nums,Integer[] dp){
    //     if(left>=dp.length) return 0;
    //     if(dp[left]!=null) return dp[left];
    //     int a=Integer.MIN_VALUE,b=Integer.MIN_VALUE,c=Integer.MIN_VALUE;
    //     a=nums[left]-solve(left+1,nums,dp);
    //     if(left+1<dp.length)b=nums[left]+nums[left+1]-solve(left+2,nums,dp);
    //     if(left+2<dp.length) c=nums[left]+nums[left+1]+nums[left+2]-solve(left+3,nums,dp);
    //     return dp[left]=Math.max(a,Math.max(b,c));
    // }
    public String stoneGameIII(int[] stoneValue) {
        // int n=stoneValue.length;
        // Integer [] dp=new Integer[n];
        // int val=solve(0,stoneValue,dp);
        // if(val>0) return "Alice";
        // else if(val<0) return "Bob";
        // else return "Tie";

        int n=stoneValue.length;
        Integer[] dp=new Integer[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int a, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE;
            a=stoneValue[i]-dp[i+1];
            if(i+1<n) b=stoneValue[i]+stoneValue[i+1]-dp[i+2];
            if(i+2<n) c=stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-dp[i+3];
            dp[i] = Math.max(a, Math.max(b, c));
        }
        int val=dp[0];
        if(val>0) return "Alice";
        else if(val<0) return "Bob";
        else return "Tie";
    }
}