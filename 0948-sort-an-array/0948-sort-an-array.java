class Solution {
    public void mergeSort(int[] nums,int beg,int end){
        int mid;
        if(beg<end){
            mid=beg + (end - beg) / 2;
            mergeSort(nums,beg,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,beg,mid,end);
        }
    }
    public void merge(int[] nums,int beg,int mid,int end){
        int i=beg,j=mid+1,index=beg;
        int[] temp=new int[nums.length];
        while(i<=mid&&j<=end){
            if(nums[i]<nums[j]){
                temp[index]=nums[i];
                i++;
            }else{
                temp[index]=nums[j];
                j++;
            }
            index++;
        }
        while(i<=mid){
            temp[index]=nums[i];
            i++;
            index++;
        }
        while(j<=end){
            temp[index]=nums[j];
            j++;
            index++;
        }
        for(int k=beg;k<index;k++){
            nums[k]=temp[k];
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}