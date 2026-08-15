class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,ans=0,n=s.length();
        HashSet<Character> set=new HashSet<>();
        for(int right=0;right<n;right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}