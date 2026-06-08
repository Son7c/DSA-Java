class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int left=0,right=0,len=0;
        while(right<s.length()){
            while(left<s.length()&&set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            len=Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
}