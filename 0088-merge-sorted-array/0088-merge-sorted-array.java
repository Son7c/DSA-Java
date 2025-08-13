class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lp=0,rp=0,idx=0;
        int temp[]=new int[m+n];
        while(lp<m&&rp<n){
            if(nums1[lp]<=nums2[rp]){
                temp[idx++]=nums1[lp++];
            }else{
                temp[idx++]=nums2[rp++];
            }
        }
        while(lp<m) temp[idx++]=nums1[lp++];
        while(rp<n) temp[idx++]=nums2[rp++];
        for(int i=0;i<m+n;i++){
            nums1[i]=temp[i];
        }
    }
}