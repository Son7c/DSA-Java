class Solution {
    String ans="";
    public void checkOdd(int i,String s){
        int left=i,right=i;
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if(ans.length()<right-left-1){
            ans=s.substring(left+1,right);
        }
    }
    public void checkEven(int i,String s){
        int left=i,right=i+1;
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if(ans.length()<right-left-1){
            ans=s.substring(left+1,right);
        }
    }
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            checkEven(i,s);
            checkOdd(i,s);
        }
        if(ans.length()==0) ans+=s.charAt(0);
        return ans;
    }
}