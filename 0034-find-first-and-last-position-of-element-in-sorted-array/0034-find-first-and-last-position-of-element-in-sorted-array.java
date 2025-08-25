class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==1&&nums[0]==target) return new int[]{0,0};
        int lp=0,rp=nums.length-1;
        while(lp<=rp){
            if(nums[lp]==target&&nums[rp]==target) return new int[]{lp,rp};
            if(nums[lp]<target){
                lp++;
            }
            if(nums[rp]>target){
                rp--;
            }
        }
        return new int[]{-1,-1};
    }
}