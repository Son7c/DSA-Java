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
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(i<n-1&&((ch=='I'&&s.charAt(i+1)=='V')||(ch=='I'&&s.charAt(i+1)=='X'))){
                ans+=val(s.charAt(i+1))-val(ch);
                i++;
            }else if(i<n-1&&((ch=='X'&&s.charAt(i+1)=='L')||(ch=='X'&&s.charAt(i+1)=='C'))){
                ans+=val(s.charAt(i+1))-val(ch);
                i++;
            }else if(i<n-1&&((ch=='C'&&s.charAt(i+1)=='D')||(ch=='C'&&s.charAt(i+1)=='M'))){
                ans+=val(s.charAt(i+1))-val(ch);
                i++;
            }else{
                ans+=val(ch);
            }
        }
        return ans;
    }
}