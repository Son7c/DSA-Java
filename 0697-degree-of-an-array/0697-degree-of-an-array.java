class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        HashMap<Integer,Integer> first=new HashMap<>();
        HashMap<Integer,Integer> last=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            last.put(nums[i],i);
        }
        for(int i=nums.length-1;i>=0;i--){
            first.put(nums[i],i);
        }

        int deg=Integer.MIN_VALUE;
        for(int i:freq.keySet()){
            deg=Math.max(deg,freq.get(i));
        }
        int length=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(freq.get(nums[i])==deg){
                length=Math.min(length,last.get(nums[i])-first.get(nums[i])+1);
            }
        }
        return length;
    }
}