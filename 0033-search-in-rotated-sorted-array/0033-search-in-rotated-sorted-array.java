class Solution {
    public int binary(int[] nums,int target,int left, int right){
        if(left>right){
            return -1;
        }
        int mid=left+((right-left)/2);
        if(nums[mid]==target){
            return mid;
        }
        if(nums[0]<=nums[mid]){
            if(target>=nums[left]&& target<=nums[mid]){
                return binary(nums,target,left,mid-1);
            }else{
                return binary(nums,target,mid+1,right);
            }
        }else{
            if(target>=nums[mid]&&target<=nums[right]){
                return binary(nums,target,mid+1,right);
            }else{
                return binary(nums,target,left,mid-1);
            }
        }
    }
    public int search(int[] nums, int target) {
        return binary(nums,target,0,nums.length-1);
    }
}