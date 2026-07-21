class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lp=0,rp=arr.length-1;
        while(lp<=rp){
            int mid=(lp+(rp-lp)/2);
            int missing=arr[mid]-(mid+1);
            if(missing<k){
                lp=mid+1;
            }else{
                rp=mid-1;
            }
        }
        return lp+k;
    }
}