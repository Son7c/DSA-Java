class Solution {
    public void mergeSort(int[] nums,int beg,int end){
        if(beg>=end) return;
        int mid=beg + (end - beg) / 2;
        mergeSort(nums,beg,mid);
        mergeSort(nums,mid+1,end);
        merge(nums,beg,mid,end);
    }
    public void merge(int[] nums,int beg,int mid,int end){
        int i=beg,j=mid+1,k=0;
        int[] temp=new int[end-beg+1];
        while(i<=mid&&j<=end){
            temp[k++]=(nums[i]<nums[j])?nums[i++]:nums[j++];
        }
        while(i<=mid){
            temp[k++]=nums[i++];
        }
        while(j<=end){
            temp[k++]=nums[j++];
        }
        for(int z=0;z<temp.length;z++){
            nums[beg+z]=temp[z];
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}