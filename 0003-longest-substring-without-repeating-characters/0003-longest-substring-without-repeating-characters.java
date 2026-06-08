class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int left=0,len=0;
        for(int right=0;right<s.length();right++){
            while(left<s.length()&&set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            len=Math.max(len,right-left+1);
        }
        return len;
    }
}