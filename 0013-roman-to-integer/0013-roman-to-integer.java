class Solution {
    public int val(char ch){
        switch (ch){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    public int romanToInt(String s) {
        int ans=0,i=0;
        while(i<s.length()){
            if(i!=s.length()-1&&s.charAt(i)=='I'&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')){
                ans+=val(s.charAt(i+1))-1;
                i+=2;
            }else if(i!=s.length()-1&&s.charAt(i)=='X'&&(s.charAt(i+1)=='L'||s.charAt(i+1)=='C')){
                ans+=val(s.charAt(i+1))-10;
                i+=2;
            }
            else if(i!=s.length()-1&&s.charAt(i)=='C'&&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M')){
                ans+=val(s.charAt(i+1))-100;
                i+=2;
            }
            else{
                ans+=val(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}