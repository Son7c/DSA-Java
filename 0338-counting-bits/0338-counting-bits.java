class Solution {
    public int[] countBits(int n) {
        int arr[]=new int[n+1],count=0;
        for(int i=0;i<=n;i++){
            int num=i;count=0;
            while(num!=0){
                if((num&1)==1) count+=1;
                num=num>>1;
            }
            arr[i]=count;
        }
        return arr;
    }
}