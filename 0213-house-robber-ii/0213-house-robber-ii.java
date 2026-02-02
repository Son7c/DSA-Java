class Solution {
    public int f1(int i,int[] nums,int[]dp1){
        if(i<0) return 0;
        if(i==0) return nums[0];
        if(dp1[i]!=-1) return dp1[i];
        int pick=nums[i]+f1(i-2,nums,dp1);
        int notPick=0+f1(i-1,nums,dp1);
        return dp1[i]=Math.max(pick,notPick);
    }
    public int f2(int i,int[] nums,int[]dp2){
        if(i<=0) return 0;
        if(i==1) return nums[1];
        if(dp2[i]!=-1) return dp2[i];
        int pick=nums[i]+f2(i-2,nums,dp2);
        int notPick=0+f2(i-1,nums,dp2);
        return dp2[i]=Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<0) return 0;
        if(n==1) return nums[0];
        int dp1[]=new int[n];
        int dp2[]=new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        //0-> n-2
        int case1=f1(n-2,nums,dp1);

        //1-> n-1
        int case2=f2(n-1,nums,dp2);

        return Math.max(case1,case2);
    }
}