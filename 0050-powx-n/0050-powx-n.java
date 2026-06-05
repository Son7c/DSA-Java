class Solution {
    public double myPow(double x, int n) {
        long m=n;
        m=Math.abs(m);
        double ans=1.0;
        while(m>0){
            if(m%2==0){
                m=m/2;
                x=x*x;
            }else{
                ans*=x;
                m=m-1;
            }
        }
        return n<0?1.0/ans:ans;
    }
}