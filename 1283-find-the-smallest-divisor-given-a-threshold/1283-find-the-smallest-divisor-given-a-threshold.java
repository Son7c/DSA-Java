class Solution {
    public int find(int[] nums,int mid){
        int val=0;
        for(int i=0;i<nums.length;i++){
            // val+=(int)Math.ceil((double)((double) nums[i]/(double)mid));
            val+=(nums[i]+mid-1)/mid;
        }
        return val;
    }
    public int smallestDivisor(int[] nums, int th) {
        int left=1,right=-1,ans=-1;
        for(int i:nums){
            right=Math.max(i,right);
        }
        while(left<=right){
            int mid=(left+(right-left)/2);
            int val=find(nums,mid);
            if(val<=th){
                right=mid-1;
                ans=mid;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}