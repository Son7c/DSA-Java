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
        while(lp<word1.length()){
            str+=word1.charAt(lp);
            lp++;
        }
        while(rp<word2.length()){
            str+=word2.charAt(rp);
            rp++;
        }
        return str;
    }
}