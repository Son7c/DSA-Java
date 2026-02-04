class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lp=0,rp=nums.length-1;
        int ans[]=new int[]{-1,-1};
        while(lp<=rp){
            int mid=lp+((rp-lp)/2);
            if(nums[mid]==target){
                ans[0]=mid;
                rp=mid-1;
            }else if(nums[mid]<target){
                lp=mid+1;
            }else{
                rp=mid-1;
            }
        }
        lp=0;
        rp=nums.length-1;
        while(lp<=rp){
            int mid=lp+((rp-lp)/2);
            if(nums[mid]==target){
                ans[1]=mid;
                lp=mid+1;
            }
            else if(nums[mid]<target){
                lp=mid+1;
            }else{
                rp=mid-1;
            }
        }
        return ans;
    }
}