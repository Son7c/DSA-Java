class Solution {
    public int find(int[] nums, int mid){
        int c=0,x=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>mid) return -1;
            c+=nums[i];
            if(i==nums.length-1){
                if(c>mid) x++;
                if(c<=mid) x++;
            }
            if(c>mid){
                c=nums[i];
                x++;
            }
        }
        return x;
    }
    public int shipWithinDays(int[] weights, int days) {
        int lp=1,rp=0;
        for(int i:weights){
            rp+=i;
        }
        while(lp<=rp){
            int mid=(lp+(rp-lp)/2);
            int val=find(weights,mid);
            if(val!=-1&&val<=days){
                rp=mid-1;
            }else{
                lp=mid+1;
            }
        }
        return lp;
    }
}