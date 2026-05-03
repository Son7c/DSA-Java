class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        int sum=0;
        int f_prev=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            f_prev+=i*nums[i];
        }
        int max=f_prev;
        for(int i=0;i<n;i++){
            f_prev=sum+f_prev-(n*nums[n-i-1]);
            max=Math.max(max,f_prev);
        }
        return max;
    }
}