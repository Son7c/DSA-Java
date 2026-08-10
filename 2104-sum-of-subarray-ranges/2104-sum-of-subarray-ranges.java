class Solution {
    public long subArrayRanges(int[] nums) {
        long ans=0l;
        for(int i=0;i<nums.length;i++){
            long min=Long.MAX_VALUE,max=Long.MIN_VALUE;
            for(int j=i;j<nums.length;j++){
                max=Math.max(max,(long) nums[j]);
                min=Math.min(min,(long) nums[j]);
                ans+=max-min;
            }
        }
        return ans;
    }
}