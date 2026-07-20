class Solution {
    public boolean find(int[] arr, int m, int k,int mid){
        int x=0,y=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                y++;
            }else if(arr[i]>mid&&y!=0){
                y=0;
            }
            if(y==k){
                x++;
                y=0;
            }
            if(x==m) return true;
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int lp=1,rp=-1,ans=Integer.MAX_VALUE,max=-1;
        for(int i:bloomDay){
            rp=Math.max(rp,i);
        }
        max=rp;
        while(lp<=rp){
            int mid=(lp+(rp-lp)/2);
            boolean res=find(bloomDay,m,k,mid);
            if(res){
                rp=mid-1;
            }
            else{
                lp=mid+1;
            }
        }
        return lp>max?-1:lp;
    }
}