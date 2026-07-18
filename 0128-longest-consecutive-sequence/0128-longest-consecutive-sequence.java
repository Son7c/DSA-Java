class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        TreeSet<Integer> set=new TreeSet<>();
        for(int i:nums) set.add(i);
        int prev=(int) 1e9+1;
        int count=1,max=1;
        for(int i:set){
            if(prev==(int) 1e9+1) {
                prev=i;
                continue;
            }
            if(i==prev+1) count++;
            else{
                max=Math.max(max,count);
                count=1;
            }
            prev=i;
        }
        if(count>1) max=Math.max(max,count);
        return max;
    }
}