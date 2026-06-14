class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0,n=nums.length,maxi=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                maxi=Math.max(count,maxi);
                count=0;
            }else count++;
        }
        maxi=Math.max(count,maxi);
        return maxi;
    }
}