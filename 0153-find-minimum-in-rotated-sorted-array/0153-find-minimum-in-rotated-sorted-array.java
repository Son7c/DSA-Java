class Solution {
    public int findMin(int[] nums) {
        int lp=0,rp=nums.length-1,min=Integer.MAX_VALUE;
        while(lp<=rp){
            int mid=lp+((rp-lp)/2);
            //left half sorted
            if(nums[lp]<=nums[mid]){
                min=Math.min(min,nums[lp]);
                lp=mid+1;
            }else{
                min=Math.min(min,nums[mid]);
                rp=mid-1;
            }
        }
        return min;
    }
}