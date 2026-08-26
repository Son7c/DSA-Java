class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<String> list=new ArrayList<>();
        int left=0,minLen=Integer.MAX_VALUE,end=-1;
        int start=0;
        String ans="";
        for(int right=0;right<s.length();right++){
            if(s.charAt(right)=='1') k--;
            while(k==0){
                String curr=s.substring(left,right+1);
                if(s.charAt(left)=='1') k++;
                if(minLen>right-left+1){
                    start=left;
                    minLen=right-left+1;
                    ans=curr;
                }
                else if(minLen==right-left+1){
                    if(curr.compareTo(ans)<0) ans=curr;
                }
                left++;
            }
        }
        return ans;
    }
}