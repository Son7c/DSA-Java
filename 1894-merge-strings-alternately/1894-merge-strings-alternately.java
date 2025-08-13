class Solution {
    public String mergeAlternately(String word1, String word2) {
        int lp=0,rp=0;
        String str="";
        while(lp<word1.length()&&rp<word2.length()){
            str+=word1.charAt(lp);
            str+=word2.charAt(rp);
            lp++;
            rp++;
        }
        if(lp<word1.length()) str+=word1.substring(lp);
        else if(rp<word2.length()) str+=word2.substring(rp);
        return str;
    }
}