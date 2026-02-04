class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,maxf=0,maxLen=0;
        int[] freq=new int[26];
        while(r<s.length()){
            freq[s.charAt(r)-'A']++;
            maxf=Math.max(freq[s.charAt(r)-'A'],maxf);
            while(r-l+1-maxf>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            if(r-l+1-maxf<=k){
                maxLen=Math.max(maxLen,r-l+1);
            }else{
                break;
            }
            r++;
        }
        return maxLen;
    }
}