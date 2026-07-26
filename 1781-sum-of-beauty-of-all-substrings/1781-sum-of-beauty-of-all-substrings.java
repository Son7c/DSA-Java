class Solution {
    public int beautySum(String s) {
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
                int min = Integer.MAX_VALUE;
                int max = 0;
                for (int f : freq) {
                    if (f > 0) {
                        min = Math.min(f, min);
                        max = Math.max(f, max);
                    }
                }
                sum+=max-min;
            }
        }
        return sum;
    }
}