class Solution {
    public int time(int[] piles,int h, int t){
        int totalHours=0;
        for(int i=0;i<piles.length;i++){
            totalHours+=Math.ceil((double)piles[i]/t);
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }
        int left=1;
        while(left<=max){
            int mid=left+((max-left)/2);
            if(time(piles,h,mid)<=h){
                max=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}