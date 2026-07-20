class Solution {
    public int mySqrt(int x) {
        long lp=0,rp=x;
        while(lp<=rp){
            long mid=(lp+(rp-lp)/2);
            if(mid*mid==(long) x) return (int) mid;
            if(mid*mid>(long) x) rp=mid-1;
            else if(mid*mid<(long) x) lp=mid+1;
        }
        return (int) rp;
    }
}