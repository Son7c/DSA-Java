class Solution {
    private int isPalindrome(String s,int left,int right){
        int count=0;
        while(left>=0 &&right<s.length() &&s.charAt(left)==s.charAt(right)){
            count++;
            right++;
            left--;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count+=isPalindrome(s,i,i);
            count+=isPalindrome(s,i,i+1);
        }
        
        return count;
    }
}