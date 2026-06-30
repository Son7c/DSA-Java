class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length()==0) return 0;
        int sign=1,i=0,digit=0;
        if(s.charAt(0)=='-'){
            sign=-1;
            i=1;
        }
        else if(s.charAt(0)=='+'){
            i=1;
        }
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int d=s.charAt(i)-'0';
            if(digit>(Integer.MAX_VALUE-d)/10){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            digit=digit*10+d;
            i++;
        }
        digit=sign*digit;
        return digit;
    }
}