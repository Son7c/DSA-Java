class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        StringBuilder left=new StringBuilder(s);
        int n=s.length();
        for(int i=0;i<n;i++){
            if(left.toString().equals(goal)) return true;
            else{
                char ch=left.charAt(0);
                left.deleteCharAt(0);
                left.append(ch);
            }
        }
        return false;
    }
}