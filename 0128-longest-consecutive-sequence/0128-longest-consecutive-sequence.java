class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int ans=0;
        for(int i:set){
            int curr=i;
            int count=1;
            if(!set.contains(i-1)){
                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}