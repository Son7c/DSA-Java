class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> less=new ArrayList<>();
        ArrayList<Integer> more=new ArrayList<>();
        int count=0;
        for(int i:nums){
            if(i<pivot) less.add(i);
            else if(i==pivot) count++;
            else more.add(i);
        }
        for(int i=0;i<less.size();i++){
            nums[i]=less.get(i);
        }
        int idx=less.size();
        while(count!=0){
            nums[idx++]=pivot;
            count--;
        }
        for(int i=idx;i<nums.length;i++){
            nums[i]=more.get(i-idx);
        }
        return nums;
    }
}