class Solution {
    
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> list=new ArrayList<>();
        int th=(int)Math.floor(nums.length/3);
        for(Integer keys:map.keySet()){
            if(map.get(keys)>th) list.add(keys);
        }
        return list;
    }
}