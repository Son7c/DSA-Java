class Solution {
    // public boolean f(int[] nums,String p,int p1,int p2,int left,int right){

        //Approach-1

        // if(left>right){
        //     return p1>=p2;
        // }
        // boolean a=false,b=false;
        // if(p.equals("p1")){
        //     a=f(nums,"p2",p1+nums[left],p2,left+1,right);
        //     b=f(nums,"p2",p1+nums[right],p2,left,right-1);
        //     return a||b;
        // }else{
        //     a=f(nums,"p1",p1,p2+nums[left],left+1,right);
        //     b=f(nums,"p1",p1,p2+nums[right],left,right-1);

        //     return a&&b;
        // }
    // }

    public int f(int[] nums,int left,int right,Integer dp[][]){
        if(left>right) return 0;
        if(left==right) return nums[left];
        if(dp[left][right]!=null) return dp[left][right];

        int a=nums[left]-f(nums,left+1,right,dp);
        int b=nums[right]-f(nums,left,right-1,dp);
        return dp[left][right]=Math.max(a,b);
    }
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        Integer dp[][] =new Integer[n][n];
        return f(nums,0,n-1,dp)>=0;
    }
}