class Solution {
    public void reverseString(char[] s) {
        int lp=0,rp=s.length-1;
        while(lp<rp){
            char temp=s[rp];
            s[rp]=s[lp];
            s[lp]=temp;
            lp++;
            rp--;
        }
    }
}