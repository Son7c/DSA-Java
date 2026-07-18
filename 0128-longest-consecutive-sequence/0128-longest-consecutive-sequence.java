class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums) set.add(i);
        int count=0,max=0;
        for(int i:set){
            if(set.contains(i-1)) continue;
            else{
                int x=i;
                while(set.contains(x)){
                    count++;
                    x=x+1;
                }
                max=Math.max(max,x-i);
            }
        }
        return max;
    }
}