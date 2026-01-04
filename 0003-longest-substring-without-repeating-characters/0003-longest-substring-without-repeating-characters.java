class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet();
        int left=0,maxlen=0;
        for(int right=0;right<s.length();right++){
            while(hs.contains(s.charAt(right))){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(s.charAt(right));
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}