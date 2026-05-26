class Solution {
    public String rle(String s){
        int i=0;
        StringBuilder sb=new StringBuilder();
        while(i<=s.length()-1){
            char prev=s.charAt(i);
            int idx=i+1,count=1;
            while(idx<s.length()&&s.charAt(idx)==prev){
                idx++;
                i++;
                count++;
            }
            sb.append(count);
            sb.append(prev);
            i++;
        }
        return sb.toString();
    }
    public String countAndSay(int n) {
        if(n==1) return "1";
        return rle(countAndSay(n-1));
    }
    //
}