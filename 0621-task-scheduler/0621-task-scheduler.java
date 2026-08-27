class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        int maxFreq=0,maxFreqCount=0;
        for(int i=0;i<26;i++){
            maxFreq=Math.max(maxFreq,freq[i]);
        }
        for(int i=0;i<26;i++){
            if(freq[i]==maxFreq) maxFreqCount++;
        }
        int skelTime=(maxFreq-1)*(n + 1)+maxFreqCount;
        return Math.max(skelTime,tasks.length);
    }
}