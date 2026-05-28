class Solution {
    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public String longestPalindrome(String s) {
        String res = "";
        int maxi = 0, start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expand(s, i, i);
            int even = expand(s, i, i + 1);
            maxi = Math.max(odd, even);
            if (maxi > end - start) {
                start = i - (maxi - 1) / 2;
                end = i + maxi / 2;
            }
        }
        return s.substring(start, end + 1);
    }
}