class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> hs=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        int count=0;
        int idx=0;
        for(Integer i:hs){
            nums[idx++]=i;
            count++;
        }
        return count;
    }
}