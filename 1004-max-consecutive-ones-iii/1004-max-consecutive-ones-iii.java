class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans=0,left=0,n=nums.length;
        for(int right=0;right<n;right++){
            while(k<=0&&nums[right]==0){
                if(nums[left++]==0) k++;
            }
            if(nums[right]==0) k--;
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}