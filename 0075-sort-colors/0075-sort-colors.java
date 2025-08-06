class Solution {
    public void mergeSort(int arr[],int left,int right){
        if(left>=right) return;
        int mid=left+(right-left)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    public void merge(int []arr,int left,int mid,int right){
        int i=left,j=mid+1,k=0;
        int[] temp=new int[right-left+1];
        while(i<=mid && j<=right){
            temp[k++]=arr[i]<arr[j]?arr[i++]:arr[j++];
        }
        while(i<=mid) temp[k++]=arr[i++];
        while(j<=right) temp[k++]=arr[j++];
        System.arraycopy(temp,0,arr,left,temp.length);
    }
    public void sortColors(int[] nums) {
        mergeSort(nums,0,nums.length-1);
    }
}