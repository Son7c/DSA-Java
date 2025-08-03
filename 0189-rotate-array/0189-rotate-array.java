class Solution {
    public void rotate(int[] nums, int k) {
        int arr[]=new int[nums.length];
        k=k%nums.length;
        int idx=nums.length-k;
        int j=0;
        for(int i=idx;i<nums.length;i++){
            arr[j]=nums[i];
            j++;
        }
        for(int i=0;i<idx;i++){
            arr[j]=nums[i];
            j++;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }
    }
}