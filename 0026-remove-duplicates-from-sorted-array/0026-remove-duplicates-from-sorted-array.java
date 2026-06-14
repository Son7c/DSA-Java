class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;
        int idx=1;
        for(int i=1;i<n;i++){
            while(i<n&&nums[i]==nums[i-1]) i++;
            if(i<n) nums[idx++]=nums[i];
        }
        return idx;
    }
}