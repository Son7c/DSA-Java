class Solution {
    public int majorityElement(int[] nums) {
        HashMap <Integer,Integer> hm=new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            hm.put(nums[i], 0);
        }
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.get(nums[i])+1);
        }
        int max=nums[0];
        Set <Integer> keys=hm.keySet();
        for(int i:keys){
            if(hm.get(i)>hm.get(max)){
                max=i;
            }
        }
        return max;
    }
}