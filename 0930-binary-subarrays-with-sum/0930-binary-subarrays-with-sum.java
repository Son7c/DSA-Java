class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum=0,count=0;
        int i=0,j=0,zeroes=0;
        while(j<nums.length){
            sum+=nums[j];
            while(i<j&&(nums[i]==0||sum>goal)){
                if(nums[i]==0) zeroes++;
                else zeroes=0;
                sum-=nums[i++];
            }
            if(sum==goal){
                count=count+1+zeroes;
            }
            j++;
        }
        return count;
    }
}