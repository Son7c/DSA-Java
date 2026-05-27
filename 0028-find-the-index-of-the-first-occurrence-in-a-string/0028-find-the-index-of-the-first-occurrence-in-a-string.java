class Solution {
    public int strStr(String text, String pat) {
        int[]lps=lps(pat);
        int i=0,j=0,n=text.length(),m=pat.length();
        while(i<n){
            if(text.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            if(j==m) return i-m;
            if(i<n&&text.charAt(i)!=pat.charAt(j)){
                if(j!=0) j=lps[j-1];
                else i++;
            }
        }
        return -1;
    }
    public int[] lps(String pat){
        int m=pat.length();
        int[] lps=new int[m];
        int prev=0,i=1;
        lps[0]=0;
        while(i<m){
            if(pat.charAt(i)==pat.charAt(prev)){
                prev++;
                lps[i]=prev;
                i++;
            }else if(prev!=0){
                prev=lps[prev-1];
            }else{
                i++;
            }
        }
        return lps;
    }
}