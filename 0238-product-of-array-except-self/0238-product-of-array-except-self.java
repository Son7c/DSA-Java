class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=1;
        int count=0;
        int prod2=1;
        for(int i:nums){
            prod*=i;
            if(i==0){
                count++;
            }
            if(i!=0){
                prod2=prod2*i;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0&&count==1){
                nums[i]=prod2;
            }
            else if(nums[i]!=0){
                nums[i]=prod/nums[i];
            }
            else if(nums[i]==0&&count>1){
                nums[i]=0;
            }
        }
        return nums;
    }
}