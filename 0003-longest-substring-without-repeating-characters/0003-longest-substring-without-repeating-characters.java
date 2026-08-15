class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,ans=0,n=s.length();
        int[] last = new int[128];
        Arrays.fill(last, -1);
        for(int right=0;right<n;right++){
            char ch = s.charAt(right);
            left=Math.max(left,last[ch]+1);
            last[ch]=right;
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}