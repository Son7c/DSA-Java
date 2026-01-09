class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max1=Integer.MIN_VALUE,max2=0;
        for(int i=0;i<weights.length;i++){
            max1=Math.max(max1,weights[i]);
        }
        for(int i=0;i<weights.length;i++){
            max2+=weights[i];
        }
        int left=max1,right=max2;
        while(left<=right){
            int mid=left+((right-left)/2);
            if(load(weights,mid)>days){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
    public int load(int[] weights,int weight){
        int count=0,sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            if(sum>weight){
                count++;
                sum=weights[i];
            }
        }
        return count+1;
    }
}