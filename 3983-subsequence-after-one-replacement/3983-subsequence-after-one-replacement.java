class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n)
            return false;
        int[] prefix = new int[m + 1];
        int[] suffix = new int[m + 1];
        Arrays.fill(prefix, (int) 1e9);
        Arrays.fill(suffix, -(int) 1e9);

        prefix[0]=-1;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                prefix[i + 1] = j;
                i++;
            }
            j++;
        }
        suffix[m] = n;
        i = m - 1;
        j = n - 1;
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == t.charAt(j)) {
                suffix[i] = j;
                i--;
            }
            j--;
        }
        for (i = 0; i < m; i++) {
            int left=prefix[i];
            int right=suffix[i+1];
            if(left!=(int) 1e9&&right!=-(int) 1e9&&right-left>1) return true;
        }
        return false;
    }
}