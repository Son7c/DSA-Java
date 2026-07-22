class Solution {
    public int find(int[] nums, int mid){
        int s=0,k=1;
        for(int sum:nums){
            if(s+sum>mid){
                k++;
                s=sum;
            }else{
                s+=sum;
            }
        }
        return k;
    }
    public int splitArray(int[] nums, int k) {
        int lp=0,rp=0;
        for(int i:nums){
            lp=Math.max(lp,i);
            rp+=i;
        }
        while(lp<=rp){
            int mid=(lp+(rp-lp)/2);
            int val=find(nums,mid);
            if(val>k){
                lp=mid+1;
            }else{
                rp=mid-1;
            }
        }
        return lp;
    }
}