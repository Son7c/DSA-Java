class Solution {
    public boolean isPalindrome(String s) {
        String res=s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int lp=0,rp=res.length()-1;
        while(lp<rp){
            if(res.charAt(lp)!=res.charAt(rp)) return false;
            lp++;
            rp--;
        }
        return true;
    }
}