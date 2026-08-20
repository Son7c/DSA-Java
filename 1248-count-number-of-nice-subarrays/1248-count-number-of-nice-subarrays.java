class Solution {
    public int f(int[] nums,int k){
        if(k<0) return 0;
        int left=0,res=0,count=0,n=nums.length;
        for(int right=0;right<n;right++){
            if(nums[right]%2!=0) count++;
            while(left<=right&&count>k){
                if(nums[left]%2!=0) count--;
                left++;
            }
            res+=right-left+1;
        }
        return res;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return f(nums,k)-f(nums,k-1);
    }
}