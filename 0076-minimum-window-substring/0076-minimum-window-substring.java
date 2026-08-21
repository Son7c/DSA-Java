class Solution {
    public boolean check(int[] need,int[] freq){
        for(int i=0;i<128;i++){
            if(need[i]>freq[i]) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int[] need=new int[128];
        for(int i=0;i<t.length();i++){
            need[t.charAt(i)-'A']++;
        }
        int[] freq=new int[128];
        int left=0,len=Integer.MAX_VALUE,n=s.length(),start=0;
        for(int right=0;right<n;right++){
            char c=s.charAt(right);
            freq[c-'A']++;
            //shrink from left
            while(left<=right&&check(need,freq)){
                char ch=s.charAt(left);
                freq[ch-'A']--;
                if(right-left+1<len){
                    len=right-left+1;
                    start=left;
                }
                left++;
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}