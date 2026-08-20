class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq=new int[3];
        int left = 0, count = 0,ans=0, n = s.length();
        for (int right = 0; right < n; right++) {
            char c=s.charAt(right);
            freq[c-'a']++;
            if(freq[c-'a']==1) count++;
            while (count==3) {
                char ch=s.charAt(left);
                freq[ch-'a']--;
                if(freq[ch-'a']==0) count--;
                left++;
                ans += n - right;
            }
        }
        return ans;
    }
}