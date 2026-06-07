class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int ans=0;
        for(int i:set){
            if(!set.contains(i-1)){
                int count=1;
                while(set.contains(i+1)){
                    i++;
                    count++;
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}