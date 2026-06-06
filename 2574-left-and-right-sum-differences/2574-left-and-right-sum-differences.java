class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[]ans=new int[n];
        int left=0,right=0;
        for(int i:nums) right+=i;
        for(int i=0;i<nums.length;i++){
            left+=nums[i];
            right-=nums[i];
            ans[i]=Math.abs(left-nums[i]-right);
        }
        return ans;
    }
}