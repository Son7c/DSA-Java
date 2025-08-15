class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==1) return 1;
        TreeSet<Integer> set=new TreeSet<>();
        for(Integer i:nums){
            set.add(i);
        }
        int idx=0,ans=0;
        for(Integer i:set){
            nums[idx++]=i;
        }
        for(int i=0;i<nums.length-1;i++){
            int count=1;
            while(i<nums.length-1&&nums[i+1]==nums[i]+1){
                count++;
                i++;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}