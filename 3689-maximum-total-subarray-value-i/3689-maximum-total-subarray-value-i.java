class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min=nums[0],max=nums[0];
        for(int i:nums){
            min=Math.min(min,i);
            max=Math.max(max,i);
        }
        long diff=(long)(max-min);
        return (long) diff*k;
    }
}