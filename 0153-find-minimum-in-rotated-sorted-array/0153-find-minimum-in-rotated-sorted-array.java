class Solution {
    public int binary(int[] nums, int left,int right){
        if(left==right){
            return nums[left];
        }
        int mid=left+((right-left)/2);
        if(nums[left]<=nums[mid]){
            return Math.min(nums[left],binary(nums,mid+1,right));
        }else{
            return Math.min(nums[mid],binary(nums,left,mid-1));
        }
    }
    public int findMin(int[] nums) {
        return binary(nums,0,nums.length-1);
    }
}