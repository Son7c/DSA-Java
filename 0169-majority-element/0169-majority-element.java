class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0,count=0;
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.get(i)>count){
                count=map.get(i);
                ans=i;
            }
        }
        return ans;
    }
}