class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int mid=-1;
        while(left<right){
            mid=(left+right)/2;
            if(nums[mid]==target) return mid;

            else if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]>target){
                right=mid;
            }
        }
        if(nums[left]>target) return left;
        else if(nums[left]<target) return left+1;
        return mid+1;
    }
}