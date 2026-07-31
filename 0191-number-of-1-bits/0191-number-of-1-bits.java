class Solution {
    public int hammingWeight(int n) {
        int bitmask=1,count=0;
        while(n>0){
            if((bitmask&n)>0) count++;
            n=n>>1;
        }
        return count;
    }
}