class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i:nums) xor^=i;
        int count=0;
        while(true){
            if((xor&1)==1) break;
            xor=xor>>1;
            count++;
        }
        int setBucket=0,unsetBucket=0;
        for(int i:nums){
            if((i>>count&1)==1) setBucket^=i;
            else unsetBucket^=i;
        }
        int[] ans=new int[]{setBucket,unsetBucket};
        return ans;
    }
}