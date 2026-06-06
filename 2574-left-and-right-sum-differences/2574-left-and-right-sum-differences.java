class Solution {
    public int[] leftRightDifference(int[] nums) {
        int left=0,right=0;
        for(int i:nums) right+=i;
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            right-=nums[i];
            nums[i]=Math.abs(left-right);
            left+=val;
        }
        return nums;
    }
}