class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        Arrays.sort(freq);
        int maxFreq=freq[25];
        int maxCountFreq=0;
        for(int i:freq){
            if(i==maxFreq) maxCountFreq++;
        }
        int skeletonTime=(maxFreq-1)*(n + 1)+maxCountFreq;
        return Math.max(skeletonTime, tasks.length);
    }
}