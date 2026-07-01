class Solution {
    private int[] lps(String needle){
        int m=needle.length();
        int[]lps=new int[m];
        lps[0]=0;
        int i=1,length=0;
        while(i<m){
            if(needle.charAt(length)==needle.charAt(i)){
                length++;
                lps[i]=length;
                i++;
            }
            else if(length!=0){
                length=lps[length-1];
            }else{
                lps[i]=0;
                i++;
            }
        }
        return lps;
    }
    public int strStr(String haystack, String needle) {
        int[]lps=lps(needle);
        int i=0,j=0;
        int n=haystack.length(),m=needle.length();
        while(i<n){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            if(j==m) return i-m;
            if(i<n&&haystack.charAt(i)!=needle.charAt(j)){
                if(j!=0) j=lps[j-1];
                else i++;
            }
        }
        return -1;
    }
}