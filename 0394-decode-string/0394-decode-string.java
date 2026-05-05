class Solution {
    int track=0;
    public String f(int idx, String s) {
        if(idx==s.length()||s.charAt(idx)==']'){
            track=idx;
            return "";
        }
        int num=0;
        StringBuilder sb=new StringBuilder();
        if(Character.isDigit(s.charAt(idx))){
            while(Character.isDigit(s.charAt(idx))){
                num=num*10+s.charAt(idx)-'0';
                idx++;
            }
        }
        if(s.charAt(idx)=='['){
            String repeat=f(idx+1,s);
            for(int i=0;i<num;i++){
                sb.append(repeat);
            }
            sb.append(f(track+1,s));
        }else{
            if(s.charAt(idx)!=']'){
                sb.append(s.charAt(idx));
                sb.append(f(idx+1,s));
            }
        }
        return sb.toString();
    }
    public String decodeString(String s) {
        return(f(0,s));
    }
}