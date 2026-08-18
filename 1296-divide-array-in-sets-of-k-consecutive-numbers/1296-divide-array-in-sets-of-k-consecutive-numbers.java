class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0) return false;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        while(map.size()>0){
            int curr=map.firstKey();
            for(int i=0;i<k;i++){
                if(!map.containsKey(curr+i)) return false;
                map.put(curr+i,map.get(curr+i)-1);
                if(map.get(curr+i)==0) map.remove(curr+i);
            }
        }
        return true;
    }
}