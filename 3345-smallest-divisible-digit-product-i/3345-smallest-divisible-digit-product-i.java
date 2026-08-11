class Solution {
    public int smallestNumber(int n, int t) {
        int i=n;
        while(true){
            int temp=i,mul=1;
            while(temp>0){
                mul*=temp%10;
                temp=temp/10;
            }
            if(mul%t==0) return i;
            i++;
        }
    }
}