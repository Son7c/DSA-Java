class Solution {
    public int f(int[] piles,int num){
        int count=0;
        for(int i=0;i<piles.length;i++){
            count+=Math.ceil((double)piles[i]/num);
        }
        return count;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int high=piles[0];
        for(int i:piles) high=Math.max(high,i);
        int low=1;
        while(low<=high){
            int mid=low+((high-low)/2);
            int val=f(piles,mid);
            if(val<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}